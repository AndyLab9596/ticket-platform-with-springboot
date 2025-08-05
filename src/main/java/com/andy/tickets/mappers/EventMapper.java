package com.andy.tickets.mappers;

import com.andy.tickets.domain.dtos.CreateEventRequestDto;
import com.andy.tickets.domain.dtos.CreateEventResponseDto;
import com.andy.tickets.domain.dtos.CreateTicketTypeRequestDto;
import com.andy.tickets.domain.entities.Event;
import com.andy.tickets.domain.requests.CreateEventRequest;
import com.andy.tickets.domain.requests.CreateTicketTypeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {
    CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);

    CreateEventRequest fromDto(CreateEventRequestDto dto);

    CreateEventResponseDto toDto(Event event);
}
