package com.microservice.orderservice.Service;

import com.microservice.orderservice.Dto.InventoryResponse;
import com.microservice.orderservice.Dto.OrderDto;
import com.microservice.orderservice.Dto.OrderLineItemsDto;
import com.microservice.orderservice.Entity.Orders;
import com.microservice.orderservice.Entity.OrderLineItems;
import com.microservice.orderservice.Repo.orderRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final orderRepo orderRepo;
    private final WebClient webClient;
    private final ModelMapper modelMapper;
    public void placeOrder(OrderDto orderDto){
        Orders order = new Orders();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems = orderDto.getOrderLineItemsDtoList().stream().map(orderLineItemsDto -> modelMapper.map(orderLineItemsDto,OrderLineItems.class)).collect(Collectors.toList());
        order.setOrderLineItems(orderLineItems);

        List<String> skuCodes = order.getOrderLineItems().stream().map(orderLineItems2 -> orderLineItems2.getSkuCode()).toList();

      InventoryResponse[] inventoryResponses = webClient.get()
                        .uri("http://localhost:8082/api/inventory",uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
                                .retrieve()
                                        .bodyToMono(InventoryResponse[].class)
                                                .block();
      boolean result = Arrays.stream(inventoryResponses).allMatch(inventoryResponse -> inventoryResponse.isInStock());
      if(result){
          orderRepo.save(order);
      }
      else {
          throw new IllegalArgumentException("Product not in stock, Please try again later");
      }
    }
}
