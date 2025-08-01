package com.example.HelpDeskORM.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
// @Table(name = "support_tickets")
@DiscriminatorValue("support_ticket")
public class SupportTicket extends User {
    private long ticketId;
    private String Description;
    private String status;
    private String created_by;
    private String assigned_to;
   
    public SupportTicket() {
        
    }

  

    public SupportTicket(long ticketId, String description, String status, String created_by, String assigned_to) {
        this.ticketId = ticketId;
        Description = description;
        this.status = status;
        this.created_by = created_by;
        this.assigned_to = assigned_to;
    }
    public long getTicketId() {
        return ticketId;
    }
    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getCreated_by() {
        return created_by;
    }
    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
    public String getAssigned_to() {
        return assigned_to;
    }
    public void setAssigned_to(String assigned_to) {
        this.assigned_to = assigned_to;
    }

    @Override
    public void createsupportTicket(Ticket ticket) {

    }
    @Override
    public String toString() {
        return "SupportTicket{" +
                "ticketId=" + ticketId +
                ", Description='" + Description + '\'' +
                ", status='" + status + '\'' +
                ", created_by='" + created_by + '\'' +
                ", assigned_to='" + assigned_to + '\'' +
                '}';
    }
    @Override
    public void createuser(User user) {
    }
}
