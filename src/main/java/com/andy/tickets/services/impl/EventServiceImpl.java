package com.andy.tickets.services.impl;

import com.andy.tickets.domain.entities.Event;
import com.andy.tickets.domain.entities.TicketType;
import com.andy.tickets.domain.entities.User;
import com.andy.tickets.domain.requests.CreateEventRequest;
import com.andy.tickets.exceptions.UserNotFoundException;
import com.andy.tickets.repositories.EventRepository;
import com.andy.tickets.repositories.UserRepository;
import com.andy.tickets.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    @Override
    public Event createEvent(UUID organizerId, CreateEventRequest event) {
        User organizer = userRepository
                .findById(organizerId)
                .orElseThrow(() -> new UserNotFoundException(
                        String.format("User with ID '%s' not found ", organizerId)
                ));
        Event evenToCreate = new Event();

        List<TicketType> ticketTypesToCreate = event.getTicketTypes().stream().map(ticketType -> {
            TicketType ticketTypeToCreate = new TicketType();
            ticketTypeToCreate.setName(ticketType.getName());
            ticketTypeToCreate.setPrice(ticketType.getPrice());
            ticketTypeToCreate.setDescription(ticketType.getDescription());
            ticketTypeToCreate.setTotalAvailable(ticketType.getTotalAvailable());
            ticketTypeToCreate.setEvent(evenToCreate);
            return ticketTypeToCreate;
        }).toList();

        evenToCreate.setName(event.getName());
        evenToCreate.setStart(event.getStart());
        evenToCreate.setEnd(event.getEnd());
        evenToCreate.setVenue(event.getVenue());
        evenToCreate.setSalesStart(event.getSalesStart());
        evenToCreate.setSalesEnd(event.getSalesEnd());
        evenToCreate.setStatus(event.getStatus());
        evenToCreate.setOrganizer(organizer);
        evenToCreate.setTicketTypes(ticketTypesToCreate);

        return eventRepository.save(evenToCreate);
    }
}
