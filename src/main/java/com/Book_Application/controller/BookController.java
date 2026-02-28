package com.Book_Application.controller;


import com.Book_Application.entity.Book;
import com.Book_Application.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/book/v1")
public class BookController {

    private final BookService bookService;
    @Autowired
    public BookController(BookService bookservice) {
        this.bookService = bookservice;
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book saveBook = bookService.addBook(book);
        return ResponseEntity.ok(saveBook);
    }

    @GetMapping("/{bookName}")
    public ResponseEntity<Book> getBookByName(@PathVariable("bookName") String name) {
        final Book bookByName = bookService.getBookByName(name);
        return ResponseEntity.ok(bookByName);
    }

    @GetMapping
    public List<Book> getAllBook() {
        return bookService.getAllBook();
    }

    @PutMapping("/updateBook")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        Book savedBook = bookService.updateBook(book);
        return ResponseEntity.ok(savedBook);
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") int id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}