package com.example.HelpDeskORM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.HelpDeskORM.repository.TicketRepository;
import com.example.HelpDeskORM.domain.Ticket;
import java.util.List;
@Service
public class TicketService {
    @Autowired
    private TicketRepository TicketRepository;

    public List<Ticket> getAllTickets() {
        return TicketRepository.findAll();
    }
}
