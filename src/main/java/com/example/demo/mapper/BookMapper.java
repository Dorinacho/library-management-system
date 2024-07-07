package com.example.demo.mapper;

import com.example.demo.model.dto.book.BookDto;
import com.example.demo.model.dto.book.CreateBookDto;
import com.example.demo.model.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

  Book toBook(BookDto bookDto);

  BookDto toBookDto(Book book);

  Book toBook(CreateBookDto createBookDto);
}
