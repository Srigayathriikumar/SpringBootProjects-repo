package com.example.EcommerceApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.EcommerceApplication.service.OrderItemService;
import com.example.EcommerceApplication.domain.OrderItem;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {
    
    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/admin")
    public ResponseEntity<OrderItem> saveOrderItem(@RequestBody OrderItem orderItem) {
        OrderItem savedOrderItem = orderItemService.saveOrderItem(orderItem);
        return ResponseEntity.ok(savedOrderItem);
    }

    @GetMapping("admin/order/{orderId}")
    public ResponseEntity<List<OrderItem>> getOrderItemsByOrderId(@PathVariable Long orderId) {
        List<OrderItem> orderItems = orderItemService.getOrderItemsByOrderId(orderId);
        return ResponseEntity.ok(orderItems);
    }

}