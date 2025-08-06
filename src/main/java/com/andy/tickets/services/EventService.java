package com.andy.tickets.services;

import com.andy.tickets.domain.entities.Event;
import com.andy.tickets.domain.requests.CreateEventRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface EventService {
    Event createEvent(UUID organizerId, CreateEventRequest event);
    Page<Event> listEventForOrganizer(UUID organizerId, Pageable pageable);
}
