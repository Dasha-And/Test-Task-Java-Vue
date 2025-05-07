package org.example.calendar.service;

import org.example.calendar.model.Event;

import java.util.List;

public interface EventService {
    Event getEventById(Long id);

    List<Event> getAllEvents();

    Event createEvent(Event event);

    Event updateEvent(Long id, Event event);

    void deleteEvent(Long id);
}
