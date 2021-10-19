package com.intro.springboot.bookstoremanager.service;

import com.intro.springboot.bookstoremanager.dto.MessageResponseDTO;
import com.intro.springboot.bookstoremanager.entity.Book;
import com.intro.springboot.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(Book book){
        Book savedBook = bookRepository.save(book);

        return MessageResponseDTO.builder()
                .message("Book Created with ID " + savedBook.getId())
                .build();
    }
}
