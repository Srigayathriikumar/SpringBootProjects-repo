package com.example.HelpDeskORM.domain;
import java.util.*;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    public User getUsers(){
        return user;
    }
    public void setUsers(User user){
        this.user=user;
    }
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TicketTag> ticketTags = new HashSet<>();

    public Set<TicketTag> getTicketTags() {
        return ticketTags;
    }
    public void setTicketTags(Set<TicketTag> ticketTags) {
        this.ticketTags = ticketTags;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
