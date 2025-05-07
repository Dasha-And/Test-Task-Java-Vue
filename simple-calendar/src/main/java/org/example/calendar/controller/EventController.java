package org.example.calendar.controller;

import org.example.calendar.dto.EventDto;
import org.example.calendar.service.EventService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @GetMapping(path = "/event/{id}")
    public EventDto getEventById(@PathVariable Long id) {
        return service.getEventById(id);
    }

    @GetMapping(path = "/events")
    public List<EventDto> getAllEvents() {
        return service.getAllEvents();
    }

    @PostMapping(path = "/create-event")
    public EventDto createEvent(@RequestBody EventDto form) {
        System.out.println(form);
        return service.createEvent(form);
    }

    @DeleteMapping(path = "/delete-event")
    public void deleteEvent(@PathVariable Long id) {
        service.deleteEvent(id);
    }

    @PutMapping(path = "/edit-event")
    public EventDto editEvent(@RequestBody EventDto form) {
        return service.updateEvent(form);
    }
}
