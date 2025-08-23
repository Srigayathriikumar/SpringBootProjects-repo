package com.example.EcommerceApplication.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.EcommerceApplication.domain.Order;

public interface OrderService {
    Order placeOrder(Order order);
    List<Order> getUserOrders(Long userId);
    Page<Order> getAllOrders(Pageable pageable);
    Page<Order> getUserOrders(Long userId, Pageable pageable);
}