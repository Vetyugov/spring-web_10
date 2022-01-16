package com.geekbrains.spring.web.dto;

import com.geekbrains.spring.web.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class OrderDto {
    private Long id;
    private String username;
    private List<OrderItemDto> items;
    private Integer totalPrice;
    private String address;
    private String phone;
}
