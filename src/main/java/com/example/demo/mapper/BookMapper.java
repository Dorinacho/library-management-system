package com.example.demo.mapper;

import com.example.demo.dto.book.SaveBookDto;
import com.example.demo.dto.book.ViewBookDto;
import com.example.demo.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookMapper {

  ViewBookDto toViewBookDto(Book book);

  Book toBook(SaveBookDto saveBookDto);

  Book toBook(@MappingTarget Book book, SaveBookDto saveBookDto);
}
