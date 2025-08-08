package com.example.EventEase.service;

import java.util.List;

import com.example.EventEase.domain.Event;
public interface EventService {
    public List<Event> getAllEvents();
    public Event createEvent(Event event);
    public Event getEventById(Long id);
    public Event updateEvent(Long id, Event event);
    public void deleteEvent(Long id);
}
