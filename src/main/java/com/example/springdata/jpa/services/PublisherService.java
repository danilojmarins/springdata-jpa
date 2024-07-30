package com.example.springdata.jpa.services;

import com.example.springdata.jpa.dtos.PublisherRecordDto;
import com.example.springdata.jpa.models.Publisher;
import com.example.springdata.jpa.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public Publisher savePublisher(PublisherRecordDto publisherRecordDto) {
        Publisher publisher = new Publisher();
        publisher.setName(publisherRecordDto.name());
        return publisherRepository.save(publisher);
    }
}
