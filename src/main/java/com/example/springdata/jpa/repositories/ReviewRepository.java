package com.example.springdata.jpa.repositories;

import com.example.springdata.jpa.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review, UUID> {
}
