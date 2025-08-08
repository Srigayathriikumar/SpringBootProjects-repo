package com.example.EventEase.domain;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "usersease")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email; 
    
    @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL, orphanRemoval = true)
private List<Registration> registrations;

    public User(){

    }
    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    
}
