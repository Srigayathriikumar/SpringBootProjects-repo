package com.example.HelpDeskORM.repository;
import com.example.HelpDeskORM.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
    
    
}
