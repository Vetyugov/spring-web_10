package com.geekbrains.spring.web.services;

import com.geekbrains.spring.web.entities.Order;
import com.geekbrains.spring.web.repositories.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository ordersRepository1;

    public Optional<Order> findById(Long orderId) {
        return ordersRepository1.findById(orderId);
    }

//    public Optional<Product> findById(Long id) {
//        return productsRepository.findById(id);
//    }
//
//    public void deleteItemById(Long id) {
//        productsRepository.deleteById(id);
//    }
//
//    public Product save(Product product) {
//        return productsRepository.save(product);
//    }
//
//    @Transactional
//    public Product update(ProductDto productDto) {
//        Product product = productsRepository.findById(productDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Невозможно обновить продукта, не надйен в базе, id: " + productDto.getId()));
//        product.setPrice(productDto.getPrice());
//        product.setTitle(productDto.getTitle());
//        return product;
//    }
}
