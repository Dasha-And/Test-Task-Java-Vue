package org.example.calendar.service;

import org.example.calendar.model.Event;
import org.example.calendar.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Long id, Event event) {
        //check if event present
        getEventById(id);
        return eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long id) {
        //check if event present
        getEventById(id);
        eventRepository.deleteById(id);
    }
}
