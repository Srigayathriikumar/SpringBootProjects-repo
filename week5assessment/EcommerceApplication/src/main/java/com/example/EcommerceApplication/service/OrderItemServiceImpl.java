package com.example.EcommerceApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.EcommerceApplication.domain.OrderItem;
import com.example.EcommerceApplication.repository.OrderItemRepository;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }
}