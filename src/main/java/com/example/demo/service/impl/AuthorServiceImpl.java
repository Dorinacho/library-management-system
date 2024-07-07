package com.example.demo.service.impl;

import com.example.demo.mapper.AuthorMapper;
import com.example.demo.model.dto.author.AuthorDto;
import com.example.demo.model.entity.Author;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.service.AuthorService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

  private final AuthorRepository authorRepository;
  private final AuthorMapper authorMapper;

  @Override
  public AuthorDto getAuthorById(UUID authorId) {
    Author author = authorRepository.findById(authorId).orElseThrow();
    return authorMapper.toAuthorDto(author);
  }

  @Override
  public List<AuthorDto> getAllAuthors() {
    return authorRepository.findAll().stream()
        .map(authorMapper::toAuthorDto)
        .toList();
  }

  @Override
  public void addAuthor(AuthorDto authorDto) {
    Author author = authorMapper.toAuthor(authorDto);
    authorRepository.save(author);
  }

  @Override
  public void updateAuthor(UUID authorId, AuthorDto authorDto) {
    Author author = authorMapper.toAuthor(authorDto);
    author.setId(authorId);
    authorRepository.save(author);
  }

  @Override
  public void deleteAuthor(UUID authorId) {
    authorRepository.deleteById(authorId);
  }
}
