package com.example.HelpDeskORM;

import com.example.HelpDeskORM.controller.MainController;
import com.example.HelpDeskORM.exceptions.InvalidStatusException;
import com.example.HelpDeskORM.exceptions.TicketNotFoundException;
import com.example.HelpDeskORM.repository.SupportTicketRepositoryImpl;
import com.example.HelpDeskORM.service.SupportTicketService;

public class Main {
    public static void main(String[] args) throws TicketNotFoundException, InvalidStatusException {
        SupportTicketRepositoryImpl repo = new SupportTicketRepositoryImpl(); 
        SupportTicketService service = new SupportTicketService(repo);
        MainController con= new MainController(service);
        con.run();
    }
}
