package com.example.EventEase.mapper;
import org.springframework.stereotype.Component;

import com.example.EventEase.domain.Registration;
import com.example.EventEase.dto.*;
@Component
public class RegistrationMapper {
    public static Registration toEntity(RegistrationRequestDTO registrationDTO) {
        Registration registration = new Registration();
        registration.setId(registrationDTO.getId());
        registration.setUser_id(registrationDTO.getUser_id());
        registration.setEvent_id(registrationDTO.getEvent_id());
        return registration;
    }
    public static RegistrationResponseDTO toResponse(Registration registration) {
        RegistrationResponseDTO registrationDTO = new RegistrationResponseDTO();
        registrationDTO.setId(registration.getId());
        registrationDTO.setUser_id(registration.getUser_id());
        registrationDTO.setEvent_id(registration.getEvent_id());
        return registrationDTO;
    }
}
