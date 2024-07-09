package com.example.demo.integration.controller;

import static com.example.demo.utils.JsonPaths.PATH_AUTHOR_BIO;
import static com.example.demo.utils.JsonPaths.PATH_AUTHOR_FIRST_NAME;
import static com.example.demo.utils.JsonPaths.PATH_AUTHOR_LAST_NAME;
import static com.example.demo.utils.JsonPaths.PATH_DESCRIPTION;
import static com.example.demo.utils.JsonPaths.PATH_ISBN;
import static com.example.demo.utils.JsonPaths.PATH_TITLE;
import static com.example.demo.utils.TestConstants.VALID_DESCRIPTION;
import static com.example.demo.utils.TestConstants.VALID_ISBN;
import static com.example.demo.utils.TestConstants.VALID_TITLE;
import static com.example.demo.utils.factory.AuthorFactory.getAuthor;
import static com.example.demo.utils.factory.AuthorFactory.getValidSimpleViewAuthorDto;
import static com.example.demo.utils.factory.BookFactory.getBook;
import static com.example.demo.utils.factory.BookFactory.getInvalidSaveBookDto;
import static com.example.demo.utils.factory.BookFactory.getValidSaveBookDto;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.dto.author.SimpleViewAuthorDto;
import com.example.demo.dto.book.SaveBookDto;
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
public class BookControllerTests extends ContainerizedTest {

  @Autowired
  private BookRepository bookRepository;
  @Autowired
  private AuthorRepository authorRepository;
  @Autowired
  private MockMvc mockMvc;
  private UUID authorId;
  private Author author;

  @BeforeAll
  public void setUp() {
    bookRepository.deleteAll();
    authorRepository.deleteAll();
    author = authorRepository.save(getAuthor());
    authorId = author.getId();
  }

  @Test
  void givenBookId_whenGetBookById_thenGetBookData() throws Exception {
    Book book = getBook();
    book.setAuthor(author);
    bookRepository.save(book);
    SimpleViewAuthorDto authorDto = getValidSimpleViewAuthorDto();

    mockMvc.perform(get("/books/" + book.getId()))
        .andExpect(status().isOk())
        .andExpect(jsonPath(PATH_TITLE).value(VALID_TITLE))
        .andExpect(jsonPath(PATH_ISBN).value(VALID_ISBN))
        .andExpect(jsonPath(PATH_DESCRIPTION).value(VALID_DESCRIPTION))
        .andExpect(jsonPath(PATH_AUTHOR_BIO).value(authorDto.getBio()))
        .andExpect(jsonPath(PATH_AUTHOR_FIRST_NAME).value(authorDto.getFirstName()))
        .andExpect(jsonPath(PATH_AUTHOR_LAST_NAME).value(authorDto.getLastName()))
        .andReturn();
  }

  @Test
  void givenValidSaveBookDataDto_whenAddBook_thenReturnCreated() throws Exception {
    SaveBookDto saveBookDto = getValidSaveBookDto();
    saveBookDto.setAuthorId(authorId);

    mockMvc.perform(post("/books")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(saveBookDto)))
        .andExpect(status().isCreated());
  }

  @Test
  void givenInvalidSaveBookDataDto_whenAddBook_thenReturnBadRequest() throws Exception {
    SaveBookDto saveBookDto = getInvalidSaveBookDto();
    saveBookDto.setAuthorId(authorId);

    mockMvc.perform(post("/books")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(saveBookDto)))
        .andExpect(status().isBadRequest());
  }

  @Test
  void givenNonexistentAuthorId_whenAddBook_thenReturnNotFound() throws Exception {
    SaveBookDto saveBookDto = getValidSaveBookDto();
    saveBookDto.setAuthorId(UUID.randomUUID());

    mockMvc.perform(post("/books")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(saveBookDto)))
        .andExpect(status().isNotFound());
  }

  @Test
  void givenInvalidSaveBookDataDto_whenUpdateBook_thenReturnBadRequest() throws Exception {
    SaveBookDto saveBookDto = getInvalidSaveBookDto();

    mockMvc.perform(put("/books/" + UUID.randomUUID())
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(saveBookDto)))
        .andExpect(status().isBadRequest());
  }

  @Test
  void givenNonexistentBookId_whenUpdateBook_thenReturnNotFound() throws Exception {
    SaveBookDto saveBookDto = getValidSaveBookDto();

    mockMvc.perform(put("/books/" + UUID.randomUUID())
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(saveBookDto)))
        .andExpect(status().isNotFound());
  }

  @Test
  void givenValidBookId_whenDeleteBook_thenReturnNoContent() throws Exception {
    Book book =  getBook();
    book.setAuthor(author);
    bookRepository.save(book);

    mockMvc.perform(delete("/books/" + book.getId()))
        .andExpect(status().isNoContent());
  }

  @Test
  void givenNonexistentBookId_whenDeleteBook_thenReturnNotFound() throws Exception {
    mockMvc.perform(delete("/books/" + UUID.randomUUID()))
        .andExpect(status().isNotFound());
  }

}
