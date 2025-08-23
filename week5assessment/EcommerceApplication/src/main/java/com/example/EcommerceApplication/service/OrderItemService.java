package com.example.EcommerceApplication.service;

import java.util.List;
import com.example.EcommerceApplication.domain.OrderItem;

public interface OrderItemService {
    OrderItem saveOrderItem(OrderItem orderItem);
    List<OrderItem> getOrderItemsByOrderId(Long orderId);
}