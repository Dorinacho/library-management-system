package com.example.demo.service;

import com.example.demo.model.dto.author.AuthorDto;
import java.util.List;
import java.util.UUID;

public interface AuthorService {

  AuthorDto getAuthorById(UUID authorId);

  List<AuthorDto> getAllAuthors();

  void addAuthor(AuthorDto authorDto);

  void updateAuthor(UUID authorId, AuthorDto authorDto);

  void deleteAuthor(UUID authorId);
}
