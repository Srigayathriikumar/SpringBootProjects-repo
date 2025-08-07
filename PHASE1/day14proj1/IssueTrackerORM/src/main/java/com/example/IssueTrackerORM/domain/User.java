package com.example.IssueTrackerORM.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
@Entity
@Table(name = "userdata")

public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @NotNull(message="not null id")
    private Long id;
    @NotBlank(message="username not blank")
    @Size(min=3,max=20,message="username should be within 20 letters")
    private String username;
    @Pattern(regexp = "^(manager|HR|developer)$", message = "role must be 'manager', 'HR', or 'developer'")
    private String role;

    @OneToMany(mappedBy="assignedTo")
    private List<Bug> bugs;
    public User() {
    }
    public User(Long userId) {
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
}
