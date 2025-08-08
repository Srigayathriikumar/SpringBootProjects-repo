package com.example.EventEase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.EventEase.service.EventService;
import com.example.EventEase.mapper.EventMapper;
import com.example.EventEase.dto.EventResponseDTO;
import com.example.EventEase.domain.Event;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/api/events")
public class EventController {
    
    @Autowired
    private EventService eventService;
    

    @GetMapping("/all")
    public List<EventResponseDTO> getAllEvents() {
        List<EventResponseDTO> list = new ArrayList<>();
        for (Event event : eventService.getAllEvents()) {
            list.add(EventMapper.mapToResponse(event));
        }
        return list;
    }

    @PostMapping("/create")
    public EventResponseDTO createEvent(@RequestBody EventResponseDTO eventResponseDTO) {
        Event event = EventMapper.mapToEvent(eventResponseDTO);
        Event createdEvent = eventService.createEvent(event);
        return EventMapper.mapToResponse(createdEvent);
    }

    @PutMapping("/update/{id}")
    public EventResponseDTO updateEvent(@PathVariable Long id, @RequestBody EventResponseDTO eventResponseDTO) {
        Event event = EventMapper.mapToEvent(eventResponseDTO);
        Event updatedEvent = eventService.updateEvent(id, event);
        return updatedEvent != null ? EventMapper.mapToResponse(updatedEvent) : null;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return "Event with ID " + id + " deleted successfully.";
    }
}
