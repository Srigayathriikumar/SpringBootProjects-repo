package com.example.EventEase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EventEase.domain.User;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUsername(String username);
    public User findByEmail(String email);
    
    
}
