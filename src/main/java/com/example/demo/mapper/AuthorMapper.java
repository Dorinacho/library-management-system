package com.example.demo.mapper;

import com.example.demo.model.dto.AuthorDto;
import com.example.demo.model.entity.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

  AuthorDto toAuthorDto(Author author);
  Author toAuthor(AuthorDto authorDto);
}
