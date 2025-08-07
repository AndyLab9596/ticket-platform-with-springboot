package com.andy.tickets.mappers;

import com.andy.tickets.domain.dtos.*;
import com.andy.tickets.domain.entities.Event;
import com.andy.tickets.domain.entities.TicketType;
import com.andy.tickets.domain.requests.CreateEventRequest;
import com.andy.tickets.domain.requests.CreateTicketTypeRequest;
import com.andy.tickets.domain.requests.UpdateEventRequest;
import com.andy.tickets.domain.requests.UpdateTicketTypeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {
    CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);

    CreateEventRequest fromDto(CreateEventRequestDto dto);

    CreateEventResponseDto toDto(Event event);

    ListEventTicketTypeResponseDto toDto(TicketType ticketType);

    ListEventResponseDto toListEventResponseDto(Event event);

    GetEventDetailsTicketTypesResponseDto toGetEventDetailsTicketTypesResponseDto(TicketType ticketType);

    GetEventDetailsResponseDto toGetEventDetailsResponseDto(Event event);

    UpdateTicketTypeRequest fromUpdateTicketTypeRequestDto(UpdateTicketTypeRequestDto updateTicketTypeRequestDto);

    UpdateEventRequest fromUpdateEventRequestDto(UpdateEventRequestDto updateEventRequestDto);

    UpdateTicketTypeResponseDto toUpdateTicketTypeResponseDto(TicketType ticketType);

    UpdateEventResponseDto toUpdateEventResponseDto(Event event);

    ListPublishedEventResponseDto toListPublishedEventResponseDto(Event event);
}
