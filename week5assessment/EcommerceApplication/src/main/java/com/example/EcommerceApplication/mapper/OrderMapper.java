package com.example.EcommerceApplication.mapper;

import com.example.EcommerceApplication.domain.Order;
import com.example.EcommerceApplication.dto.OrderRequestDTO;
import com.example.EcommerceApplication.dto.OrderResponseDTO;

public class OrderMapper {
    
    public static Order toEntity(OrderRequestDTO orderResponseDTO){
        Order order = new Order();
        order.setId(orderResponseDTO.getId());
        order.setOrderdate(orderResponseDTO.getOrderdate());
        order.setUser(orderResponseDTO.getUser());
        order.setStatus(orderResponseDTO.getStatus());
        return order;
    }

    public static OrderResponseDTO toResponseDTO(Order order){
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setId(order.getId());
        orderResponseDTO.setOrderdate(order.getOrderdate());
        orderResponseDTO.setUser(order.getUser());
        orderResponseDTO.setStatus(order.getStatus());
        return orderResponseDTO;
    }
}
