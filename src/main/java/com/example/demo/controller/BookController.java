package com.example.demo.controller;

import com.example.demo.model.dto.BookDto;
import com.example.demo.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

  private final BookService bookService;

  @GetMapping
  public ResponseEntity<List<BookDto>> getAllBooks() {
    List<BookDto> books = bookService.getAllBooks();
    return ResponseEntity.ok().body(books);
  }
}
