package com.geekbrains.spring.web.repositories;

import com.geekbrains.spring.web.entities.Order;
import com.geekbrains.spring.web.entities.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class OrdersRepository {
    private List<Order> orders;

    @PostConstruct
    public void init() {
        orders = new ArrayList<>(List.of(
                new Order(1L, new ArrayList<>())));
    }

    public Optional<Order> findById(Long id){
        return orders.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

}
