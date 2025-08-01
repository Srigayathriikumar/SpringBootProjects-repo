package com.example.HelpDeskORM.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.HelpDeskORM.domain.Ticket;
import com.example.HelpDeskORM.service.TicketService;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
   @Autowired
    private TicketService TicketService;

    @GetMapping
    public List<Ticket> getAllTicket() {
        return TicketService.getAllTickets();
    }
 
}



