package com.example.demo.service;

import static com.example.demo.utils.factory.AuthorFactory.getAuthor;
import static com.example.demo.utils.factory.BookFactory.getBook;
import static com.example.demo.utils.factory.BookFactory.getValidSaveBookDto;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.demo.dto.book.SaveBookDto;
import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.mapper.BookMapper;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.impl.BookServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

  @Mock
  private BookRepository bookRepository;
  @Mock
  private AuthorRepository authorRepository;
  @Mock
  private BookMapper bookMapper;

  @InjectMocks
  private BookServiceImpl bookService;

  @Test
  void givenValidBookData_whenAddBook_thenSaveBook() {
    SaveBookDto bookDto = getValidSaveBookDto();
    Author author = getAuthor();
    Book book = getBook();

    when(authorRepository.findById(any(UUID.class))).thenReturn(Optional.of(author));
    when(bookMapper.toBook(any(SaveBookDto.class))).thenReturn(book);

    bookService.addBook(bookDto);

    verify(bookMapper).toBook(bookDto);
    verify(bookRepository).save(book);
    assertEquals(book, bookMapper.toBook(bookDto));
  }

  @Test
  void givenNonexistentAuthor_whenAddBook_thenThrowEntityNotFoundException() {
    SaveBookDto bookDto = getValidSaveBookDto();
    when(authorRepository.findById(any(UUID.class))).thenReturn(Optional.empty());

    assertThatThrownBy(() -> bookService.addBook(bookDto))
        .isInstanceOf(EntityNotFoundException.class)
        .hasMessage("Author with id: '" + bookDto.getAuthorId() + "' couldn't be found");
  }

  @Test
  void givenBookId_whenGetBookById_thenThrowEntityNotFoundException() {
    UUID bookId = UUID.randomUUID();

    when(bookRepository.findById(any(UUID.class))).thenReturn(Optional.empty());

    assertThatThrownBy(() -> bookService.getBookById(bookId))
        .isInstanceOf(EntityNotFoundException.class)
        .hasMessage("Book with id: '" + bookId + "' couldn't be found");
  }

  @Test
  void givenBookId_whenUpdateBook_thenThrowEntityNotFoundException() {
    SaveBookDto bookDto = getValidSaveBookDto();
    UUID bookId = UUID.randomUUID();

    when(bookRepository.findById(any(UUID.class))).thenReturn(Optional.empty());

    assertThatThrownBy(() -> bookService.updateBook(bookId, bookDto))
        .isInstanceOf(EntityNotFoundException.class)
        .hasMessage("Book with id: '" + bookId + "' couldn't be found");
  }

  @Test
  void givenBookId_whenDeleteBook_thenThrowEntityNotFoundException() {
    UUID bookId = UUID.randomUUID();

    when(bookRepository.findById(any(UUID.class))).thenReturn(Optional.empty());

    assertThatThrownBy(() -> bookService.deleteBook(bookId))
        .isInstanceOf(EntityNotFoundException.class)
        .hasMessage("Book with id: '" + bookId + "' couldn't be found");
  }
}
