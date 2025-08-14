package com.example.BankProApplication.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
public class CustomerRequestDTO {

    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "Phone number is mandatory")
    private String phoneNumber;

    public CustomerRequestDTO() {
    }
    public CustomerRequestDTO(Long id, String name, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
}
