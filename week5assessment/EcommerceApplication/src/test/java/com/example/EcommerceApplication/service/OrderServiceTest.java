package com.example.EcommerceApplication.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.example.EcommerceApplication.repository.OrderRepository;
import com.example.EcommerceApplication.domain.Order;
import com.example.EcommerceApplication.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Date;

public class OrderServiceTest {
    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPlaceOrder(){
        Order order = new Order();
        order.setStatus("PENDING");
        order.setOrderdate(new Date());
        when(orderRepository.save(order)).thenReturn(order);
        Order placedOrder = orderService.placeOrder(order);
        assertNotNull(placedOrder);
        assertEquals("PENDING", placedOrder.getStatus());
        verify(orderRepository, times(1)).save(order);
    }

    @Test
    void testGetUserOrders(){
        Order order1 = new Order(); order1.setStatus("PENDING");
        Order order2 = new Order(); order2.setStatus("COMPLETED");
        when(orderRepository.findByUserId(1L)).thenReturn(List.of(order1, order2));
        List<Order> orders = orderService.getUserOrders(1L);
        assertEquals(2, orders.size());
        assertEquals("PENDING", orders.get(0).getStatus());
        verify(orderRepository, times(1)).findByUserId(1L);
    }

    @Test
    void testGetAllOrdersPaged(){
        Order order = new Order(); order.setStatus("PENDING");
        Page<Order> page = new PageImpl<>(List.of(order));
        when(orderRepository.findAll(any(Pageable.class))).thenReturn(page);
        Page<Order> result = orderService.getAllOrders(Pageable.unpaged());
        assertEquals(1, result.getContent().size());
        verify(orderRepository, times(1)).findAll(any(Pageable.class));
    }

    @Test
    void testGetUserOrdersPaged(){
        Order order = new Order(); order.setStatus("PENDING");
        Page<Order> page = new PageImpl<>(List.of(order));
        when(orderRepository.findByUserId(eq(1L), any(Pageable.class))).thenReturn(page);
        Page<Order> result = orderService.getUserOrders(1L, Pageable.unpaged());
        assertEquals(1, result.getContent().size());
        verify(orderRepository, times(1)).findByUserId(eq(1L), any(Pageable.class));
    }
}