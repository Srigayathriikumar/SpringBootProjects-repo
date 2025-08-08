package com.example.EventEase.mapper;
import org.springframework.stereotype.Component;

import com.example.EventEase.domain.Event;
import com.example.EventEase.dto.EventResponseDTO;
@Component
public class EventMapper {
    
    public static Event mapToEvent(EventResponseDTO eventResponseDTO) {
        Event event = new Event();
        event.setId(eventResponseDTO.getId());
        event.setTitle(eventResponseDTO.getTitle());
        event.setDate(eventResponseDTO.getDate());
        event.setLocation(eventResponseDTO.getLocation());
        return event;
    }
    public static EventResponseDTO mapToResponse(Event event) {
        EventResponseDTO eventResponseDTO = new EventResponseDTO();
        eventResponseDTO.setId(event.getId());
        eventResponseDTO.setTitle(event.getTitle());
        eventResponseDTO.setDate(event.getDate());
        eventResponseDTO.setLocation(event.getLocation());
        return eventResponseDTO;
    }
}
