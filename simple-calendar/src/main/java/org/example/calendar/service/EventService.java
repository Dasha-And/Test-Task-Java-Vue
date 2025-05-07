package org.example.calendar.service;

import org.example.calendar.dto.EventDto;

import java.util.List;

public interface EventService {
    EventDto getEventById(Long id);

    List<EventDto> getAllEvents();

    EventDto createEvent(EventDto event);

    EventDto updateEvent(EventDto event);

    void deleteEvent(Long id);
}
