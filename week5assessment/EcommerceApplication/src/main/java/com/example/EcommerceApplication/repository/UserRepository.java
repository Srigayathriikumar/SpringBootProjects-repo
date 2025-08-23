package com.example.EcommerceApplication.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.EcommerceApplication.domain.User;

public interface UserRepository extends JpaRepository<User,Long> {
    
}
