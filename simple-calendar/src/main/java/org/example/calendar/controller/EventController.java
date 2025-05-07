package org.example.calendar.controller;

import lombok.RequiredArgsConstructor;
import org.example.calendar.model.Event;
import org.example.calendar.service.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @GetMapping(path = "/events")
    public List<Event> getAllEvents() {
        return service.getAllEvents();
    }
}
