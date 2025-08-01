package com.example.HelpDeskORM.service;

import java.util.List;

import com.example.HelpDeskORM.domain.SupportTicket;
import com.example.HelpDeskORM.exceptions.InvalidStatusException;
import com.example.HelpDeskORM.exceptions.TicketNotFoundException;
import com.example.HelpDeskORM.repository.SupportTicketRepository;

public class SupportTicketService {
    SupportTicketRepository supportTicketRepository;
    public SupportTicketService(SupportTicketRepository supportTicketRepository) {
        this.supportTicketRepository = supportTicketRepository;
    }
    public void createSupportTicket(SupportTicket supportTicket) {
        supportTicketRepository.createSupportTicket(supportTicket);
    }
    public List<SupportTicket> getAllTickets() throws TicketNotFoundException {
        if(supportTicketRepository.getAllTickets().isEmpty()) {
            throw new TicketNotFoundException("No tickets found");
        }
        return supportTicketRepository.getAllTickets();
    }

    public void setticketstatus(long ticketid) throws InvalidStatusException {
        if(ticketid <= 0) {
            throw new InvalidStatusException("cannot change status of a ticket with ID less than or equal to zero");
        }
        supportTicketRepository.setticketstatus(ticketid);
    }
    public void assignticket(long ticketid, String assignedTo) {
        if(ticketid <= 0 || assignedTo == null || assignedTo.isEmpty()) {
            throw new IllegalArgumentException("Invalid ticket ID or assigned agent");
        }
        supportTicketRepository.assignticket(ticketid, assignedTo);
    }
}
