package com.example.springdata.jpa.repositories;

import com.example.springdata.jpa.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
