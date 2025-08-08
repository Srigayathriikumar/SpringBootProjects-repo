package com.example.EventEase.dto;
import java.sql.Date;

import jakarta.validation.constraints.*;
public class RegistrationRequestDTO {
   
    private Long id;
    @NotBlank(message = "Event ID is required")
    private Long event_id;
    @NotBlank(message = "User ID is required")
    private Long user_id;
    
    
    public RegistrationRequestDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
    
    
}
