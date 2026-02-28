package com.Book_Application.repository;

import com.Book_Application.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

    Book findBookByTitle(String title);
}