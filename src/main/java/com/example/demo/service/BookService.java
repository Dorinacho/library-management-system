package com.example.demo.service;

import com.example.demo.dto.book.SaveBookDto;
import com.example.demo.dto.book.ViewBookDto;
import java.util.List;
import java.util.UUID;

public interface BookService {

  List<ViewBookDto> getAllBooks();

  void addBook(SaveBookDto saveBookDto);

  void updateBook(UUID bookId, SaveBookDto saveBookDto);

  void deleteBook(UUID bookId);

  ViewBookDto getBookById(UUID bookId);
}
