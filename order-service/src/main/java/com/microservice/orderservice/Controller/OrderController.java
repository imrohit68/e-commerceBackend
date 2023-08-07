package com.microservice.orderservice.Controller;

import com.microservice.orderservice.Dto.OrderDto;
import com.microservice.orderservice.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping
    public String placeOrder(@RequestBody OrderDto orderDto){
        orderService.placeOrder(orderDto);
        return "Order placed";
    }
}
