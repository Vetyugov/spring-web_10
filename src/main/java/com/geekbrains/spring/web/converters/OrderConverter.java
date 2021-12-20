package com.geekbrains.spring.web.converters;

import com.geekbrains.spring.web.dto.OrderDto;
import com.geekbrains.spring.web.entities.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {
    public Order dtoToEntity(OrderDto orderDto) {
        return new Order(orderDto.getId(), orderDto.getProducts());
    }

    public OrderDto entityToDto(Order order) {
        return new OrderDto(order.getId(), order.getProducts());
    }
}
