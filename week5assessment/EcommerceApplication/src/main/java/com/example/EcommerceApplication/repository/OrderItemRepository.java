package com.example.EcommerceApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.EcommerceApplication.domain.OrderItem;
import com.example.EcommerceApplication.domain.Order;
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

    List<OrderItem> findByOrder(Order order);
    List<OrderItem> findByOrderId(Long orderId);
    
}
