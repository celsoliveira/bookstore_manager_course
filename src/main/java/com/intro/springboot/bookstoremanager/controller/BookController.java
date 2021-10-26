package com.intro.springboot.bookstoremanager.controller;

import com.intro.springboot.bookstoremanager.dto.BookDTO;
import com.intro.springboot.bookstoremanager.dto.MessageResponseDTO;
import com.intro.springboot.bookstoremanager.entity.Book;
import com.intro.springboot.bookstoremanager.exception.BookNotFoundException;
import com.intro.springboot.bookstoremanager.repository.BookRepository;
import com.intro.springboot.bookstoremanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody @Valid BookDTO bookDTO) {
        return bookService.create(bookDTO);
    }

    @GetMapping("/{id}")
    public BookDTO findById(@PathVariable Long id) throws BookNotFoundException {
        return bookService.findById(id);
    }

    @GetMapping
    public List<Book> findAll(){
        return bookService.findAll();
    }

    /*
    @GetMapping
    public String teste(){
        return "Teste chamade metodo GET";
    }
     */
}