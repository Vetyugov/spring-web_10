package com.geekbrains.spring.web.controllers;

import com.geekbrains.spring.web.converters.OrderConverter;
import com.geekbrains.spring.web.converters.ProductConverter;
import com.geekbrains.spring.web.dto.OrderDto;
import com.geekbrains.spring.web.dto.ProductDto;
import com.geekbrains.spring.web.entities.Order;
import com.geekbrains.spring.web.entities.Product;
import com.geekbrains.spring.web.exceptions.ResourceNotFoundException;
import com.geekbrains.spring.web.services.OrdersService;
import com.geekbrains.spring.web.services.ProductsService;
import com.geekbrains.spring.web.validators.ProductValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@Slf4j
public class OrdersController {
    private final OrdersService orderService;
    private final OrderConverter orderConverter;
    private final ProductsService productsService;
//    private final ProductValidator orderValidator;

    @GetMapping("/{id}")
    public OrderDto findOrderById(@PathVariable Long id) {
        Order order = orderService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found, id: " + id));
        return orderConverter.entityToDto(order);
    }

    @PutMapping("/add")
    public OrderDto addToOrder(@RequestParam Long orderId, @RequestParam Long productId) {
        Order order = orderService.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order not found, id: " + orderId));
        Product product = productsService.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + productId));
        order.getProducts().add(product);
        return orderConverter.entityToDto(order);
    }

    //тут лучше @PutMapping или @DeleteMapping?
    //Стоит ли возвращать OrderDto, если на фронте всё-равно вызываю метод, загружающий заказ заново?
    //Правильно ли, что ProductsService добавил как приватное поле этого класса (OrdersController)?
    @PutMapping("/delete")
    public OrderDto deleteFromOrder(@RequestParam Long orderId, @RequestParam Long productId) {
        Order order = orderService.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order not found, id: " + orderId));
        Product product = productsService.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + productId));
        order.getProducts().remove(product);
        return orderConverter.entityToDto(order);
    }


}
