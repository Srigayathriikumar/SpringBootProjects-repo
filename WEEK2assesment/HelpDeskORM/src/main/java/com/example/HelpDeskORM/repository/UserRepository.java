package com.example.HelpDeskORM.repository;
import com.example.HelpDeskORM.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
    
    
}
