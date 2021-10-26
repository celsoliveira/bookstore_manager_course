package com.intro.springboot.bookstoremanager.service;

import com.intro.springboot.bookstoremanager.dto.BookDTO;
import com.intro.springboot.bookstoremanager.dto.MessageResponseDTO;
import com.intro.springboot.bookstoremanager.entity.Book;
import com.intro.springboot.bookstoremanager.exception.BookNotFoundException;
import com.intro.springboot.bookstoremanager.mapper.BookMapper;
import com.intro.springboot.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @Autowired
    public BookService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(BookDTO bookDTO){

        Book bookToSave = bookMapper.toModel(bookDTO);

        Book savedBook = bookRepository.save(bookToSave);

        return MessageResponseDTO.builder()
                .message("Book Created with ID " + savedBook.getId())
                .build();
    }

    public BookDTO findById(Long id) throws BookNotFoundException{
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        return bookMapper.toDTO(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
