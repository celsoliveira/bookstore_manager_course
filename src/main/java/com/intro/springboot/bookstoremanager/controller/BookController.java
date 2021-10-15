package com.intro.springboot.bookstoremanager.controller;

import com.intro.springboot.bookstoremanager.dto.MessageResponseDTO;
import com.intro.springboot.bookstoremanager.entity.Book;
import com.intro.springboot.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody Book book){
        Book savedBook = bookRepository.save(book);

        return MessageResponseDTO.builder()
                .message("Book Created with ID " + savedBook.getId())
                .build();
    }

    @GetMapping
    public String teste(){
        return "Teste";
    }
}
