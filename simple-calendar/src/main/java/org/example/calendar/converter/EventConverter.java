package org.example.calendar.converter;

import org.example.calendar.dto.EventDto;
import org.example.calendar.model.Event;
import org.springframework.stereotype.Component;

@Component
public class EventConverter {

    public Event fromDto(EventDto dto) {
        return new Event(
                dto.getId(),
                dto.getTitle(),
                dto.getDescription(),
                dto.getLocation(),
                dto.getStartDate(),
                dto.getEndDate());
    }

    public EventDto toDto(Event model) {
        return new EventDto(
                model.getId(),
                model.getTitle(),
                model.getDescription(),
                model.getLocation(),
                model.getStartDate(),
                model.getEndDate());
    }
}
