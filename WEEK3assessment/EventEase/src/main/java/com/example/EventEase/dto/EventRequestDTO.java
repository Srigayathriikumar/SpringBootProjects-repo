package com.example.EventEase.dto;
import jakarta.validation.constraints.*;
public class EventRequestDTO {
    
    private Long id;
    @NotBlank(message = "Event name is required")
    @Size(min = 3, max = 50, message = "Event name must be between 3 and 50 characters")
    private String name;
    @NotBlank(message="Event description is required")
    @Size(min = 10, max = 200, message = "Event description must be between 10 and 200 characters")
    private String description;
    
    @NotBlank(message = "Event date is required")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Event date must be in the format YYYY-MM-DD")
    private String date;

    @NotBlank(message = "Event location is required")
    @Size(min = 3, max = 100, message = "Event location must be between 3 and 100 characters")
    private String location;

    public EventRequestDTO() {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    


}
