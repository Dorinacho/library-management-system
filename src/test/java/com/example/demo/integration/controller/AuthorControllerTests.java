package com.example.demo.integration.controller;

import static com.example.demo.utils.JsonPaths.PATH_BIO;
import static com.example.demo.utils.JsonPaths.PATH_BOOK_DESCRIPTION;
import static com.example.demo.utils.JsonPaths.PATH_BOOK_ISBN;
import static com.example.demo.utils.JsonPaths.PATH_BOOK_TITLE;
import static com.example.demo.utils.JsonPaths.PATH_FIRST_NAME;
import static com.example.demo.utils.JsonPaths.PATH_LAST_NAME;
import static com.example.demo.utils.factory.AuthorFactory.getAuthor;
import static com.example.demo.utils.factory.AuthorFactory.getInvalidSaveAuthorDto;
import static com.example.demo.utils.factory.AuthorFactory.getValidSaveAuthorDto;
import static com.example.demo.utils.factory.AuthorFactory.getValidViewAuthorDto;
import static com.example.demo.utils.factory.BookFactory.getBook;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.dto.author.SaveAuthorDto;
import com.example.demo.dto.author.ViewAuthorDto;
import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.integration.ContainerizedTest;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import java.util.UUID;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.junit.jupiter.Testcontainers;

@TestInstance(value = Lifecycle.PER_CLASS)
@Testcontainers
@AutoConfigureMockMvc
@SpringBootTest
public class AuthorControllerTests extends ContainerizedTest {

  @Autowired
  private AuthorRepository authorRepository;
  @Autowired
  private BookRepository bookRepository;
  @Autowired
  private MockMvc mockMvc;

  @BeforeAll
  public void setUp() {
    authorRepository.deleteAll();
  }

  @Test
  void givenAuthorId_whenGetAuthorById_thenGetAuthorData() throws Exception {
    Author author = authorRepository.save(getAuthor());
    Book book = getBook();
    book.setAuthor(author);
    bookRepository.save(book);
    ViewAuthorDto authorDto = getValidViewAuthorDto();

    mockMvc.perform(get("/authors/" + author.getId()))
        .andExpect(status().isOk())
        .andExpect(jsonPath(PATH_BIO).value(authorDto.getBio()))
        .andExpect(jsonPath(PATH_FIRST_NAME).value(authorDto.getFirstName()))
        .andExpect(jsonPath(PATH_LAST_NAME).value(authorDto.getLastName()))
        .andExpect(jsonPath(PATH_BOOK_TITLE).value(authorDto.getBooks().getFirst().getTitle()))
        .andExpect(jsonPath(PATH_BOOK_ISBN).value(authorDto.getBooks().getFirst().getIsbn()))
        .andExpect(
            jsonPath(PATH_BOOK_DESCRIPTION).value(authorDto.getBooks().getFirst().getDescription()))
        .andReturn();
  }

  @Test
  void givenValidSaveAuthorDataDto_whenAddAuthor_thenReturnCreated() throws Exception {
    SaveAuthorDto saveAuthorDto = getValidSaveAuthorDto();

    mockMvc.perform(post("/authors")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(saveAuthorDto)))
        .andExpect(status().isCreated());
  }

  @Test
  void givenInvalidSaveAuthorDataDto_whenAddAuthor_thenReturnBadRequest() throws Exception {
    SaveAuthorDto saveAuthorDto = getInvalidSaveAuthorDto();

    mockMvc.perform(post("/authors")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(saveAuthorDto)))
        .andExpect(status().isBadRequest());
  }

  @Test
  void givenValidSaveAuthorDataDto_whenUpdateAuthor_thenReturnOk() throws Exception {
    Author author = authorRepository.save(getAuthor());
    SaveAuthorDto saveAuthorDto = getValidSaveAuthorDto();

    mockMvc.perform(put("/authors/" + author.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(saveAuthorDto)))
        .andExpect(status().isOk());
  }

  @Test
  void givenInvalidSaveAuthorDataDto_whenUpdateAuthor_thenReturnBadRequest() throws Exception {
    SaveAuthorDto saveAuthorDto = getInvalidSaveAuthorDto();

    mockMvc.perform(put("/authors/" + UUID.randomUUID())
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(saveAuthorDto)))
        .andExpect(status().isBadRequest());
  }

  @Test
  void givenNonexistentAuthor_whenUpdateAuthor_thenReturnNotFound() throws Exception {
    SaveAuthorDto saveAuthorDto = getValidSaveAuthorDto();

    mockMvc.perform(put("/authors/" + UUID.randomUUID())
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(saveAuthorDto)))
        .andExpect(status().isNotFound());
  }

  @Test
  void givenValidAuthorId_whenDeleteAuthor_thenReturnNoContent() throws Exception {
    Author author = authorRepository.save(getAuthor());

    mockMvc.perform(delete("/authors/" + author.getId()))
        .andExpect(status().isNoContent());
  }

  @Test
  void givenNonexistentAuthorId_whenDeleteAuthor_thenReturnNotFound() throws Exception {
    mockMvc.perform(delete("/authors/" + UUID.randomUUID()))
        .andExpect(status().isNotFound());
  }
}
