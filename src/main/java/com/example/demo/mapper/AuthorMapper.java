package com.example.demo.mapper;

import com.example.demo.dto.author.SaveAuthorDto;
import com.example.demo.dto.author.SimpleViewAuthorDto;
import com.example.demo.dto.author.ViewAuthorDto;
import com.example.demo.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

  ViewAuthorDto toViewAuthorDto(Author author);
  SimpleViewAuthorDto toSimpleViewAuthorDto(Author author);

  Author toAuthor(SaveAuthorDto saveAuthorDto);
  Author toAuthor(@MappingTarget Author author, SaveAuthorDto saveAuthorDto);
}
