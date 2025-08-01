package com.example.HelpDeskORM.repository;
import com.example.HelpDeskORM.domain.TicketTag;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TicketTagRepository extends JpaRepository<TicketTag, Long> {
    
}
