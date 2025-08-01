package com.example.HelpDeskORM.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket_tags")
public class TicketTag {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;
    
}
