package com.intro.springboot.bookstoremanager.controller;

import com.intro.springboot.bookstoremanager.dto.MessageResponseDTO;
import com.intro.springboot.bookstoremanager.entity.Book;
import com.intro.springboot.bookstoremanager.repository.BookRepository;
import com.intro.springboot.bookstoremanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody Book book) {
        return bookService.create(book);
    }
}