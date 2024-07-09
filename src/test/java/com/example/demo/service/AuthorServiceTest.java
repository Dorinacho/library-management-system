package com.example.demo.service;

import static com.example.demo.utils.factory.AuthorFactory.getAuthor;
import static com.example.demo.utils.factory.AuthorFactory.getValidSaveAuthorDto;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.demo.dto.author.SaveAuthorDto;
import com.example.demo.entity.Author;
import com.example.demo.mapper.AuthorMapper;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.service.impl.AuthorServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

  @Mock
  private AuthorRepository authorRepository;
  @Mock
  private AuthorMapper authorMapper;

  @InjectMocks
  private AuthorServiceImpl authorService;

  @Test
  void givenAuthorId_whenGetAuthorById_thenThrowEntityNotFoundException() {
    UUID authorId = UUID.randomUUID();

    when(authorRepository.findById(any(UUID.class))).thenReturn(Optional.empty());

    assertThatThrownBy(() -> authorService.getAuthorById(authorId))
        .isInstanceOf(EntityNotFoundException.class)
        .hasMessage("Author with id: '" + authorId + "' couldn't be found");
  }

  @Test
  void givenValidAuthorData_whenAddAuthor_thenSaveAuthor() {
    SaveAuthorDto authorDto = getValidSaveAuthorDto();
    Author author = getAuthor();

    when(authorMapper.toAuthor(any(SaveAuthorDto.class))).thenReturn(author);

    authorService.addAuthor(authorDto);

    verify(authorMapper).toAuthor(authorDto);
    verify(authorRepository).save(author);
    assertEquals(author, authorMapper.toAuthor(authorDto));
  }

  @Test
  void givenAuthorId_whenUpdateAuthor_thenThrowEntityNotFoundException() {
    SaveAuthorDto authorDto = getValidSaveAuthorDto();
    UUID authorId = UUID.randomUUID();

    when(authorRepository.findById(any(UUID.class))).thenReturn(Optional.empty());

    assertThatThrownBy(() -> authorService.updateAuthor(authorId, authorDto))
        .isInstanceOf(EntityNotFoundException.class)
        .hasMessage("Author with id: '" + authorId + "' couldn't be found");
  }

  @Test
  void givenAuthorId_whenDeleteAuthor_thenThrowEntityNotFoundException() {
    UUID authorId = UUID.randomUUID();

    when(authorRepository.findById(any(UUID.class))).thenReturn(Optional.empty());

    assertThatThrownBy(() -> authorService.deleteAuthor(authorId))
        .isInstanceOf(EntityNotFoundException.class)
        .hasMessage("Author with id: '" + authorId + "' couldn't be found");
  }
}
