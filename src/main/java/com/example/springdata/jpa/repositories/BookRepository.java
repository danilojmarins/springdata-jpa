package com.example.springdata.jpa.repositories;

import com.example.springdata.jpa.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {

    Book findBookByTitle(String title);

    @Query(value = "SELECT * FROM books WHERE publisher_id = :id", nativeQuery = true)
    List<Book> findBooksByPublisherId(@Param("id") UUID id);
}
