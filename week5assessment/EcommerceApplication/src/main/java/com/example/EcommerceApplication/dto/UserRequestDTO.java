package com.example.EcommerceApplication.dto;
import jakarta.validation.constraints.*;
public class UserRequestDTO {
    
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    @Email(message="Email format is wrong")
    private String email;
    @NotBlank(message="Role is required")
    private String role;
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
    public UserRequestDTO() {
    }
    public UserRequestDTO(Long id, String name, String email,String role,String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.password = password;
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
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
