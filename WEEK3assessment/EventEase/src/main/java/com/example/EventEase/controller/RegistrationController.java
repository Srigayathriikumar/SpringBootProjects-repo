package com.example.EventEase.controller;

import java.util.ArrayList;
import java.util.List;
import com.example.EventEase.domain.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.EventEase.domain.User;
import com.example.EventEase.dto.RegistrationResponseDTO;
import com.example.EventEase.dto.UserResponseDTO;
import com.example.EventEase.mapper.RegistrationMapper;
import com.example.EventEase.service.RegistrationService;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {
    
    @Autowired
    private RegistrationService registrationService;

    @Autowired
    public RegistrationMapper registrationMapper;

    @GetMapping("/all")
    public List<RegistrationResponseDTO> getallRegistrations(){
        List<RegistrationResponseDTO> list = new ArrayList<>();
        for(Registration register : registrationService.getAllRegistrations()) {
            list.add(registrationMapper.toResponse(register));
        }
        return list;
    }

    @PostMapping("/create")
    public RegistrationResponseDTO createRegistration(@RequestBody Registration registration) {
        Registration createdRegistration = registrationService.createRegistration(registration);
        return registrationMapper.toResponse(createdRegistration);
    }

    @PutMapping("/register/{userId}/{eventId}")
    public Registration registerUserToEvent(@PathVariable Long userId, @PathVariable Long eventId) {
        return registrationService.registerUserToEvent(userId, eventId);
    }

    @GetMapping("/event/{eventId}")
    public Registration getRegistrationForSpecificEvent(@PathVariable Long eventId) {
        return registrationService.getRegistrationForSpecificEvent(eventId);
    }
}

