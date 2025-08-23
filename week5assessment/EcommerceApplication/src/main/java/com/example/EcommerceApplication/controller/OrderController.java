package com.example.EcommerceApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import com.example.EcommerceApplication.service.OrderService;
import com.example.EcommerceApplication.domain.Order;
import com.example.EcommerceApplication.dto.OrderRequestDTO;
import com.example.EcommerceApplication.dto.OrderResponseDTO;
import com.example.EcommerceApplication.mapper.OrderMapper;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<OrderResponseDTO> placeOrder(@RequestBody OrderRequestDTO requestDTO) {
        Order order = OrderMapper.toEntity(requestDTO);
        Order placedOrder = orderService.placeOrder(order);
        return ResponseEntity.ok(OrderMapper.toResponseDTO(placedOrder));
    }

    @GetMapping("/user/{userId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<OrderResponseDTO>> getUserOrders(@PathVariable Long userId, Authentication auth) {
        // Users can only view their own orders, admins can view any
        if (!auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            // Additional check needed to verify userId matches authenticated user
        }
        List<Order> orders = orderService.getUserOrders(userId);
        List<OrderResponseDTO> response = orders.stream()
            .map(OrderMapper::toResponseDTO)
            .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/{userId}/paged")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Page<OrderResponseDTO>> getUserOrdersPaged(@PathVariable Long userId, Pageable pageable) {
        Page<Order> orders = orderService.getUserOrders(userId, pageable);
        Page<OrderResponseDTO> response = orders.map(OrderMapper::toResponseDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Page<OrderResponseDTO>> getAllOrders(Pageable pageable) {
        Page<Order> orders = orderService.getAllOrders(pageable);
        Page<OrderResponseDTO> response = orders.map(OrderMapper::toResponseDTO);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/user/{userId}/date-range")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<OrderResponseDTO>> getUserOrdersByDateRange(
            @PathVariable Long userId,
            @RequestParam String startDate,
            @RequestParam String endDate) {
        try {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            java.util.Date start = sdf.parse(startDate);
            java.util.Date end = sdf.parse(endDate);
            
            List<Order> orders = orderService.getUserOrdersByDateRange(userId, start, end);
            List<OrderResponseDTO> response = orders.stream()
                .map(OrderMapper::toResponseDTO)
                .collect(Collectors.toList());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}