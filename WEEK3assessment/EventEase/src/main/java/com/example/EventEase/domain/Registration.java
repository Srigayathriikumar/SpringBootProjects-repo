package com.example.EventEase.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "registrationsease")
public class Registration {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("userId")
    @Column(name = "user_id")
    private Long user_id;
    @JsonProperty("eventId")
    @Column(name = "event_id")
    private Long event_id;
    @JsonProperty("registrationDate")
    @Column(name = "registration_date", nullable = false, updatable = false)
    
    private Date registrationDate = new Date(System.currentTimeMillis());

    @PrePersist
    protected void onCreate() {
        this.registrationDate = new Date(System.currentTimeMillis());
    }

    @ManyToOne
@JoinColumn(name = "user_id", insertable = false, updatable = false)
private User user;

    @ManyToOne
    @JoinColumn(name = "event_id", insertable = false, updatable = false)
    private Event event;

    public Registration() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    
    
}
