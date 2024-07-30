package com.example.springdata.jpa.services;

import com.example.springdata.jpa.dtos.AuthorRecordDto;
import com.example.springdata.jpa.models.Author;
import com.example.springdata.jpa.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author saveAuthor(AuthorRecordDto authorRecordDto) {
        Author author = new Author();
        author.setName(authorRecordDto.name());
        return authorRepository.save(author);
    }
}
