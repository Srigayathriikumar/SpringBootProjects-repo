package com.example.HelpDeskORM.domain;

public class SupportAgent extends User {
    private String department;
    private String role;

    public SupportAgent() {
        
    }
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    @Override
    public void createsupportTicket(Ticket ticket) {
        System.out.println("Creating support ticket for user: " + getUsername() + " in department: " + department);
    }

    @Override
    public void createuser(User user) {
        System.out.println("Creating user: ");
        System.out.println("Username: " + user.getUsername());
        System.out.println("Email: " + user.getEmail());
        System.out.println("User created successfully");
    }
    
}
