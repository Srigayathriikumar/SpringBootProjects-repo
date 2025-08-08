package com.example.EventEase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;
import com.example.EventEase.domain.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
    public Event findByTitle(String title);
    public Event findByLocation(String location);
    public List<Event> findByDate(Date date);
    
}
