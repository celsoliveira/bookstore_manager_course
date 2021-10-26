package com.intro.springboot.bookstoremanager.mapper;

import com.intro.springboot.bookstoremanager.dto.BookDTO;
import com.intro.springboot.bookstoremanager.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book toModel(BookDTO bookDTO);

    BookDTO toDTO(Book book);
}
