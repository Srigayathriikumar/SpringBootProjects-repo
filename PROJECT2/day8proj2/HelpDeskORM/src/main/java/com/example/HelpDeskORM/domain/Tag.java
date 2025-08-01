package com.example.HelpDeskORM.domain;
import java.util.*;
import jakarta.annotation.Generated;
import jakarta.persistence.*;

@Entity
@Table(name = "tags")
public class Tag {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TicketTag> ticketTags = new HashSet<>();
    public Set<TicketTag> getTicketTags() {
        return ticketTags;
    }
    public void setTicketTags(Set<TicketTag> ticketTags) {
        this.ticketTags = ticketTags;
    }
    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
