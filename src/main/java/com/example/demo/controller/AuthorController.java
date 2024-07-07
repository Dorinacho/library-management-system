package com.example.demo.controller;

import com.example.demo.model.dto.author.AuthorDto;
import com.example.demo.service.AuthorService;
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
  public ResponseEntity<List<AuthorDto>> getAllAuthors() {
    List<AuthorDto> authors = authorService.getAllAuthors();
    return ResponseEntity.ok().body(authors);
  }

  @GetMapping("/{authorId}")
  public ResponseEntity<AuthorDto> getAuthorById(@PathVariable(name = "authorId") UUID authorId) {
    AuthorDto author = authorService.getAuthorById(authorId);
    return ResponseEntity.ok().body(author);
  }

  @PostMapping
  public void addAuthor(@RequestBody AuthorDto authorDto) {
    authorService.addAuthor(authorDto);
  }

  @PutMapping("/{authorId}")
  public void updateAuthor(@PathVariable(name = "authorId") UUID authorId, @RequestBody AuthorDto authorDto) {
    authorService.updateAuthor(authorId, authorDto);
  }

  @DeleteMapping("/{authorId}")
  public void deleteAuthor(@PathVariable(name = "authorId") UUID authorId) {
    authorService.deleteAuthor(authorId);
  }
}
