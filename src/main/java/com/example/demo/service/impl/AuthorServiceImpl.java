package com.example.demo.service.impl;

import com.example.demo.mapper.AuthorMapper;
import com.example.demo.mapper.BookMapper;
import com.example.demo.dto.author.SaveAuthorDto;
import com.example.demo.dto.author.SimpleViewAuthorDto;
import com.example.demo.dto.author.ViewAuthorDto;
import com.example.demo.entity.Author;
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
  private final BookMapper bookMapper;

  @Override
  public ViewAuthorDto getAuthorById(UUID authorId) {
    Author author = authorRepository.findById(authorId).orElseThrow();
    return authorMapper.toViewAuthorDto(author);
  }

  @Override
  public List<SimpleViewAuthorDto> getAllAuthors() {
    return authorRepository.findAll().stream()
        .map(authorMapper::toSimpleViewAuthorDto)
        .toList();
  }

  @Override
  public void addAuthor(SaveAuthorDto saveAuthorDto) {
    Author author = authorMapper.toAuthor(saveAuthorDto);
    authorRepository.save(author);
  }

  @Override
  public void updateAuthor(UUID authorId, SaveAuthorDto saveAuthorDto) {
    Author oldAuthor = authorRepository.findById(authorId).orElseThrow();
    Author updatedAuthor = authorMapper.toAuthor(oldAuthor, saveAuthorDto);
    authorRepository.save(updatedAuthor);
  }

  @Override
  public void deleteAuthor(UUID authorId) {
    authorRepository.deleteById(authorId);
  }
}
