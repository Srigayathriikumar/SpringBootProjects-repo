package com.example.EventEase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EventEase.domain.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    public Registration findByUser_id(Long userId);
    public Registration findByEvent_id(Long eventId);    
}
