package com.example.demo.service.impl;

import com.example.demo.mapper.BookMapper;
import com.example.demo.model.dto.book.BookDto;
import com.example.demo.model.dto.book.CreateBookDto;
import com.example.demo.model.entity.Author;
import com.example.demo.model.entity.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;
  private final AuthorRepository authorRepository;
  private final BookMapper bookMapper;

  @Override
  public List<BookDto> getAllBooks() {
    return bookRepository.findAll().stream()
        .map(bookMapper::toBookDto)
        .toList();
  }

  @Override
  public BookDto getBookById(UUID bookId) {
    Book book = bookRepository.findById(bookId).orElseThrow();
    return bookMapper.toBookDto(book);
  }

  @Override
  public void addBook(CreateBookDto createBookDto) {
    Author author = authorRepository.findById(createBookDto.getAuthorId()).orElseThrow();
    Book book = bookMapper.toBook(createBookDto);
    book.setAuthor(author);
    bookRepository.save(book);
  }

  @Override
  public void updateBook(UUID bookId, CreateBookDto createBookDto) {
    Author author = authorRepository.findById(createBookDto.getAuthorId()).orElseThrow();
    Book book = Book.builder()
        .id(bookId)
        .isbn(createBookDto.getIsbn())
        .title(createBookDto.getTitle())
        .description(createBookDto.getDescription())
        .author(author)
        .build();
    bookRepository.save(book);
  }

  @Override
  public void deleteBook(UUID bookId) {
    bookRepository.deleteById(bookId);
  }

}
