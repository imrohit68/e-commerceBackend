package com.microservice.orderservice.Dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class OrderDto {
    private List<OrderLineItemsDto> orderLineItemsDtoList;
}
