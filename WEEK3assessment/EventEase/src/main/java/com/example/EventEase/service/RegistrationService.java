package com.example.EventEase.service;
import java.util.List;

import com.example.EventEase.domain.Registration;
public interface RegistrationService {
    public List<Registration> getAllRegistrations();
    public Registration createRegistration(Registration registration);
    public Registration registerUserToEvent(Long userId, Long eventId);
    public Registration getRegistrationForSpecificEvent(Long eventId);

}
