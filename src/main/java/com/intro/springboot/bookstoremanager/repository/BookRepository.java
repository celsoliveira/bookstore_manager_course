package com.intro.springboot.bookstoremanager.repository;

import com.intro.springboot.bookstoremanager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
