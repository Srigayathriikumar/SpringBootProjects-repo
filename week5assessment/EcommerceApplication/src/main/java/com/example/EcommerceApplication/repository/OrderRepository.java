package com.example.EcommerceApplication.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.EcommerceApplication.domain.Order;
import com.example.EcommerceApplication.domain.User;
public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findByUser(User user);
    List<Order> findByUserId(Long userId);
    Page<Order> findAll(Pageable pageable);
    Page<Order> findByUserId(Long userId, Pageable pageable);
    
}
