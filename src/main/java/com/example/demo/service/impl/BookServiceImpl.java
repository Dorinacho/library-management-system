package com.example.demo.service.impl;

import com.example.demo.mapper.BookMapper;
import com.example.demo.dto.book.SaveBookDto;
import com.example.demo.dto.book.ViewBookDto;
import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
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
  public List<ViewBookDto> getAllBooks() {
    return bookRepository.findAll().stream()
        .map(bookMapper::toViewBookDto)
        .toList();
  }

  @Override
  public ViewBookDto getBookById(UUID bookId) {
    Book book = bookRepository.findById(bookId).orElseThrow();
    return bookMapper.toViewBookDto(book);
  }

  @Override
  public void addBook(SaveBookDto saveBookDto) {
    Author author = authorRepository.findById(saveBookDto.getAuthorId()).orElseThrow();
    Book book = bookMapper.toBook(saveBookDto);
    book.setAuthor(author);
    bookRepository.save(book);
  }

  @Override
  public void updateBook(UUID bookId, SaveBookDto saveBookDto) {
    Book oldBook = bookRepository.findById(bookId).orElseThrow();
    Book updatedBook = bookMapper.toBook(oldBook, saveBookDto);
    bookRepository.save(updatedBook);
  }

  @Override
  public void deleteBook(UUID bookId) {
    bookRepository.deleteById(bookId);
  }

}
