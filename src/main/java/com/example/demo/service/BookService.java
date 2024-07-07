package com.example.demo.service;

import com.example.demo.model.dto.book.BookDto;
import com.example.demo.model.dto.book.CreateBookDto;
import java.util.List;
import java.util.UUID;

public interface BookService {

  List<BookDto> getAllBooks();

  void addBook(CreateBookDto createBookDto);

  void updateBook(UUID bookId, CreateBookDto createBookDto);

  void deleteBook(UUID bookId);

  BookDto getBookById(UUID bookId);
}
