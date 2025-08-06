package com.example.IssueTrackerORM.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.IssueTrackerORM.domain.User;
public interface UserRepository extends JpaRepository<User, Long> {
   List<User> findByUsername(String username);
    
    
     

    @Query("SELECT u FROM User u WHERE u.role = :role")
     List<User> findByRole(@Param("role") String role);
}
