package com.example.EventEase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EventEase.repository.EventRepository;
import com.example.EventEase.domain.Event;
@Service
public class EventServiceImpl implements EventService {
   
    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }
    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }
    @Override
    public Event updateEvent(Long id, Event event) {
        if (eventRepository.existsById(id)) {
            event.setId(id);
            return eventRepository.save(event);
        }
        return null;
    }
    @Override
    public void deleteEvent(Long id) {
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
        }
    }
    
}
