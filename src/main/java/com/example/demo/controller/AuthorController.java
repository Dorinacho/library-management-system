package com.example.demo.controller;

import com.example.demo.dto.author.SaveAuthorDto;
import com.example.demo.dto.author.SimpleViewAuthorDto;
import com.example.demo.dto.author.ViewAuthorDto;
import com.example.demo.service.AuthorService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

  private final AuthorService authorService;

  @GetMapping
  public ResponseEntity<List<SimpleViewAuthorDto>> getAllAuthors() {
    List<SimpleViewAuthorDto> authors = authorService.getAllAuthors();
    return ResponseEntity.ok().body(authors);
  }

  @GetMapping("/{authorId}")
  public ResponseEntity<ViewAuthorDto> getAuthorById(
      @PathVariable(name = "authorId") UUID authorId) {
    ViewAuthorDto author = authorService.getAuthorById(authorId);
    return ResponseEntity.ok().body(author);
  }

  @PostMapping
  public void addAuthor(@Valid @RequestBody SaveAuthorDto saveAuthorDto) {
    authorService.addAuthor(saveAuthorDto);
  }

  @PutMapping("/{authorId}")
  public void updateAuthor(@Valid @RequestBody SaveAuthorDto saveAuthorDto,
      @PathVariable(name = "authorId") UUID authorId) {
    authorService.updateAuthor(authorId, saveAuthorDto);
  }

  @DeleteMapping("/{authorId}")
  public void deleteAuthor(@PathVariable(name = "authorId") UUID authorId) {
    authorService.deleteAuthor(authorId);
  }
}
