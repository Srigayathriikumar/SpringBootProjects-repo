package com.example.EventEase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EventEase.repository.RegistrationRepository;
import com.example.EventEase.domain.Registration;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }
    @Override
    public Registration createRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }
    
    @Override
    public Registration registerUserToEvent(Long userId, Long eventId) {
        Registration registration = new Registration();
        registration.setUser_id(userId);
        registration.setEvent_id(eventId);
        return registrationRepository.save(registration);
    }
    @Override
    public Registration getRegistrationForSpecificEvent(Long eventId) {
        return registrationRepository.findByEvent_id(eventId);
    }
    
  
    
}
