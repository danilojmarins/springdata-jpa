package com.example.springdata.jpa.controllers;

import com.example.springdata.jpa.dtos.PublisherRecordDto;
import com.example.springdata.jpa.models.Publisher;
import com.example.springdata.jpa.services.PublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookstore/publishers")
public class PublisherController {
    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping
    public ResponseEntity<Publisher> savePublisher(@RequestBody PublisherRecordDto publisherRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(publisherService.savePublisher(publisherRecordDto));
    }
}
