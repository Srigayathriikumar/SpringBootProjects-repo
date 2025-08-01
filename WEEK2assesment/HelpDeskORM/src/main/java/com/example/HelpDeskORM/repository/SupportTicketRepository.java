package com.example.HelpDeskORM.repository;

import java.util.List;

import com.example.HelpDeskORM.domain.SupportTicket;

public interface SupportTicketRepository {
    public void createSupportTicket(SupportTicket supportTicket);
    public List<SupportTicket> getAllTickets();
    public void setticketstatus(long ticketid);
    public void assignticket(long ticketid, String assignedTo);
}


