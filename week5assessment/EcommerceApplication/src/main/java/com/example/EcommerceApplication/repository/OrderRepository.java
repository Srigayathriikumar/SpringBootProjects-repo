package com.example.EcommerceApplication.repository;

import java.util.List;
import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.EcommerceApplication.domain.Order;
import com.example.EcommerceApplication.domain.User;
public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findByUser(User user);
    List<Order> findByUserId(Long userId);
    Page<Order> findAll(Pageable pageable);
    Page<Order> findByUserId(Long userId, Pageable pageable);
    
    @Query("SELECT o FROM Order o WHERE o.user.id = :userId AND o.orderdate BETWEEN :startDate AND :endDate")
    List<Order> findByUserIdAndDateRange(@Param("userId") Long userId, 
                                        @Param("startDate") Date startDate, 
                                        @Param("endDate") Date endDate);
    
}
