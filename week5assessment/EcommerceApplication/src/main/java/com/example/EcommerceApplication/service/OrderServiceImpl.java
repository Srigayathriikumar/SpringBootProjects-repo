package com.example.EcommerceApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Date;
import com.example.EcommerceApplication.domain.Order;
import com.example.EcommerceApplication.domain.OrderItem;
import com.example.EcommerceApplication.domain.Product;
import com.example.EcommerceApplication.repository.OrderRepository;
import com.example.EcommerceApplication.repository.OrderItemRepository;
import com.example.EcommerceApplication.repository.ProductRepository;
import com.example.EcommerceApplication.exception.ItemOutOfStockException;

@Service
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private OrderItemRepository orderItemRepository;
    
    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public Order placeOrder(Order order) {
        // Save order first
        Order savedOrder = orderRepository.save(order);
        
        // Get order items and validate/update stock
        List<OrderItem> orderItems = orderItemRepository.findByOrderId(savedOrder.getId());
        for (OrderItem item : orderItems) {
            Product product = item.getProduct();
            if (product.getStock() < item.getQuantity()) {
                throw new ItemOutOfStockException("Product " + product.getName() + " is out of stock");
            }
            // Update stock
            product.setStock(product.getStock() - item.getQuantity());
            productRepository.save(product);
        }
        
        return savedOrder;
    }

    @Override
    public List<Order> getUserOrders(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public Page<Order> getAllOrders(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public Page<Order> getUserOrders(Long userId, Pageable pageable) {
        return orderRepository.findByUserId(userId, pageable);
    }
    
    @Override
    public List<Order> getUserOrdersByDateRange(Long userId, Date startDate, Date endDate) {
        return orderRepository.findByUserIdAndDateRange(userId, startDate, endDate);
    }
}