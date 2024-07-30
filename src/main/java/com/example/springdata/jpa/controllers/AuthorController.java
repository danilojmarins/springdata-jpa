package com.example.springdata.jpa.controllers;

import com.example.springdata.jpa.dtos.AuthorRecordDto;
import com.example.springdata.jpa.models.Author;
import com.example.springdata.jpa.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookstore/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<Author> saveAuthor(@RequestBody AuthorRecordDto authorRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.saveAuthor(authorRecordDto));
    }
}
