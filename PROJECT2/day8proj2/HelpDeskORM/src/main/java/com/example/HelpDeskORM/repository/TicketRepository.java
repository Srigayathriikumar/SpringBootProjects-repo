package com.example.HelpDeskORM.repository;
import com.example.HelpDeskORM.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    
    
}
