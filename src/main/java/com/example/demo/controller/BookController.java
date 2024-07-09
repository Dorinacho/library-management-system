package com.example.demo.controller;

import com.example.demo.dto.book.SaveBookDto;
import com.example.demo.dto.book.ViewBookDto;
import com.example.demo.service.BookService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

  private final BookService bookService;

  @GetMapping
  public ResponseEntity<List<ViewBookDto>> getAllBooks() {
    List<ViewBookDto> books = bookService.getAllBooks();
    return ResponseEntity.ok().body(books);
  }

  @GetMapping("/{bookId}")
  public ResponseEntity<ViewBookDto> getBookById(@PathVariable(name = "bookId") UUID bookId) {
    ViewBookDto book = bookService.getBookById(bookId);
    return ResponseEntity.ok().body(book);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public void addBook(@Valid @RequestBody SaveBookDto saveBookDto) {
    bookService.addBook(saveBookDto);
  }

  @ResponseStatus(HttpStatus.OK)
  @PutMapping("/{bookId}")
  public void updateBook(@Valid @RequestBody SaveBookDto saveBookDto,
      @PathVariable(name = "bookId") UUID bookId) {
    bookService.updateBook(bookId, saveBookDto);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{bookId}")
  public void deleteBook(@PathVariable(name = "bookId") UUID bookId) {
    bookService.deleteBook(bookId);
  }

}
