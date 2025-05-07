package org.example.calendar.service;

import org.example.calendar.converter.EventConverter;
import org.example.calendar.dto.EventDto;
import org.example.calendar.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventConverter eventConverter;

    public EventServiceImpl(EventRepository eventRepository, EventConverter eventConverter) {
        this.eventRepository = eventRepository;
        this.eventConverter = eventConverter;
    }

    @Override
    public EventDto getEventById(Long id) {
        return eventConverter.toDto(eventRepository.findById(id).orElseThrow());
    }

    @Override
    public List<EventDto> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(eventConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EventDto createEvent(EventDto event) {
        return eventConverter.toDto(eventRepository.save(eventConverter.fromDto(event)));
    }

    @Override
    public EventDto updateEvent(EventDto event) {
        //check if event present
        getEventById(event.getId());
        return eventConverter.toDto(eventRepository.save(eventConverter.fromDto(event)));
    }

    @Override
    public void deleteEvent(Long id) {
        //check if event present
        getEventById(id);
        eventRepository.deleteById(id);
    }
}
