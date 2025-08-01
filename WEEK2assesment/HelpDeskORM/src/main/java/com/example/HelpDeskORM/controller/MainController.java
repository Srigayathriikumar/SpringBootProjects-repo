package com.example.HelpDeskORM.controller;
import java.util.*;

import com.example.HelpDeskORM.domain.SupportAgent;
import com.example.HelpDeskORM.domain.SupportTicket;
import com.example.HelpDeskORM.exceptions.InvalidStatusException;
import com.example.HelpDeskORM.exceptions.TicketNotFoundException;
import com.example.HelpDeskORM.service.SupportTicketService;
public class MainController {
    Scanner s=new Scanner(System.in);
        SupportTicketService supportTicketService;
        SupportAgent supportAgent;
    public MainController(SupportTicketService supportTicketService) {
        this.supportTicketService = supportTicketService;
    }
    public void run() throws TicketNotFoundException, InvalidStatusException {
        
        boolean running = true;
        while (running) {
        System.out.println("\nWelcome to the Help Desk ORM Application!");
        
        System.out.println("1. Create user");
        System.out.println("2. create support ticket");
        System.out.println("3. Assign ticket to support agent");
        System.out.println("4. Resolve ticket");
        System.out.println("5. View tickets(from JDBC)");
        System.out.println("6. Exit");
        System.out.println("Please select an option:");
        int choice = s.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Creating user...");
                createuser();
                System.out.println("---------------------------");
                System.out.println();
                break;
            case 2:
                System.out.println("Creating support ticket...");
                createSupportTicket();
                 System.out.println("---------------------------");
                System.out.println();
                break;
            case 3:
                assignticket();
                 System.out.println("---------------------------");
                 
                System.out.println();
                break;
            case 4:
                System.out.println("Resolving ticket");
                System.out.println("Enter ticket ID to resolve:");
                long tickid = s.nextLong();
                setticketstatus(tickid);
                 System.out.println("---------------------------");
                System.out.println();
                break;
            case 5:
                System.out.println("Viewing tickets from JDBC...");
                getAllTickets();
                 System.out.println("---------------------------");
                System.out.println();
                break;
            case 6:
                System.out.println("Exiting application...");
                running = false;
                return;
                
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        }
    }
    public void createSupportTicket() {
        System.out.println("Enter ticket ID:");
        long ticketId = s.nextLong();
        s.nextLine(); 
        System.out.println("Enter ticket description:");
        String description = s.nextLine();
        System.out.println("Enter ticket status:");
        String status = s.nextLine();
        System.out.println("Enter created by user:");
        String createdBy = s.nextLine();
        System.out.println("Enter assigned to user:");
        String assignedTo = s.nextLine();
        SupportTicket supportTicket = new SupportTicket(ticketId, description, status, createdBy, assignedTo);
        supportTicketService.createSupportTicket(supportTicket);
        System.out.println("Support ticket created successfully!");
    }
    public void createuser() {
        System.out.println("Enter username:");
        String username = s.nextLine();
        s.nextLine();
        System.out.println("Enter email:");
        String email = s.nextLine();
        s.nextLine();
        
        supportAgent = new SupportAgent();
        supportAgent.setUsername(username);
        supportAgent.setEmail(email);
        supportAgent.createuser(supportAgent);
    }
    public void getAllTickets() throws TicketNotFoundException {
        List<SupportTicket> tickets = supportTicketService.getAllTickets();
        if (tickets.isEmpty()) {
            System.out.println("No tickets found.");
        } else {
            System.out.println("Tickets:");
            for (SupportTicket ticket : tickets) {
                System.out.println(ticket);
            }
        }
    }
    public void setticketstatus(long ticketId) throws InvalidStatusException {
        supportTicketService.setticketstatus(ticketId);
        System.out.println("Ticket status updated to 'Resolved' for ticket ID: " + ticketId);
    }
    public void assignticket() {
        System.out.println("Enter ticket ID to assign:");
        long ticketId = s.nextLong();
        s.nextLine(); 
        System.out.println("Enter assigned agent username:");
        String assignedTo = s.nextLine();
        supportTicketService.assignticket(ticketId, assignedTo);
        System.out.println("Ticket assigned successfully to " + assignedTo + " for ticket ID: " + ticketId);
    }
}

