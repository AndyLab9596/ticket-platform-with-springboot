package com.andy.tickets.controllers;

import com.andy.tickets.domain.dtos.ListPublishedEventResponseDto;
import com.andy.tickets.mappers.EventMapper;
import com.andy.tickets.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/api/v1/published-events")
@RequiredArgsConstructor
public class PublishedEventController {
    private final EventService eventService;
    private final EventMapper eventMapper;

    @GetMapping
    public ResponseEntity<Page<ListPublishedEventResponseDto>> listPublishedEvent(Pageable pageable) {
        return ResponseEntity.ok(
                eventService
                        .listPublishedEvents(pageable)
                        .map(eventMapper::toListPublishedEventResponseDto)
        );
    }
}
