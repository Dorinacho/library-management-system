package com.example.demo.service;

import com.example.demo.dto.author.SaveAuthorDto;
import com.example.demo.dto.author.SimpleViewAuthorDto;
import com.example.demo.dto.author.ViewAuthorDto;
import java.util.List;
import java.util.UUID;

public interface AuthorService {

  ViewAuthorDto getAuthorById(UUID authorId);

  List<SimpleViewAuthorDto> getAllAuthors();

  void addAuthor(SaveAuthorDto saveAuthorDto);

  void updateAuthor(UUID authorId, SaveAuthorDto saveAuthorDto);

  void deleteAuthor(UUID authorId);
}
