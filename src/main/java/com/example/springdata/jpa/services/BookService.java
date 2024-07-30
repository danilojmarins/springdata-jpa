package com.example.springdata.jpa.services;

import com.example.springdata.jpa.dtos.BookRecordDto;
import com.example.springdata.jpa.models.Book;
import com.example.springdata.jpa.models.Review;
import com.example.springdata.jpa.repositories.AuthorRepository;
import com.example.springdata.jpa.repositories.BookRepository;
import com.example.springdata.jpa.repositories.PublisherRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Transactional
    public Book saveBook(BookRecordDto bookRecordDto) {
        Book book = new Book();
        book.setTitle(bookRecordDto.title());
        book.setPublisher(publisherRepository.findById(bookRecordDto.publisherId()).get());
        book.setAuthors(authorRepository.findAllById(bookRecordDto.authorsIds()).stream().collect(Collectors.toSet()));

        Review review = new Review();
        review.setComment(bookRecordDto.reviewComment());
        review.setBook(book);
        book.setReview(review);

        return bookRepository.save(book);
    }
}
