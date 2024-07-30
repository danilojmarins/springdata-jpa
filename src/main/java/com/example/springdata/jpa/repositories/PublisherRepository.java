package com.example.springdata.jpa.repositories;

import com.example.springdata.jpa.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublisherRepository extends JpaRepository<Publisher, UUID> {
}
