package com.example.StudentCourseManagement.dto;
import jakarta.validation.constraints.*;

public class StudentRequestDTO {
    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @Email(message="email format is invalid")
    @NotBlank(message="email is required")
    private String email;

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

    
}
