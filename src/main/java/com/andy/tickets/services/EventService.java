package com.andy.tickets.services;

import com.andy.tickets.domain.entities.Event;
import com.andy.tickets.domain.requests.CreateEventRequest;

import java.util.UUID;

public interface EventService {
    Event createEvent(UUID organizerId, CreateEventRequest event);
}
