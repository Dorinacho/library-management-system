package com.example.demo.utils.factory;

import static com.example.demo.utils.TestConstants.AUTHOR_ID;
import static com.example.demo.utils.TestConstants.INVALID_BIO;
import static com.example.demo.utils.TestConstants.INVALID_FIRST_NAME;
import static com.example.demo.utils.TestConstants.INVALID_LAST_NAME;
import static com.example.demo.utils.TestConstants.VALID_BIO;
import static com.example.demo.utils.TestConstants.VALID_FIRST_NAME;
import static com.example.demo.utils.TestConstants.VALID_LAST_NAME;
import static com.example.demo.utils.factory.BookFactory.getValidSimpleViewBookDto;

import com.example.demo.dto.author.SaveAuthorDto;
import com.example.demo.dto.author.SimpleViewAuthorDto;
import com.example.demo.dto.author.ViewAuthorDto;
import com.example.demo.entity.Author;
import java.util.List;
import java.util.UUID;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AuthorFactory {

  public static ViewAuthorDto getValidViewAuthorDto() {
    return ViewAuthorDto.builder()
        .firstName(VALID_FIRST_NAME)
        .lastName(VALID_LAST_NAME)
        .bio(VALID_BIO)
        .books(List.of(getValidSimpleViewBookDto()))
        .build();
  }

  public static SimpleViewAuthorDto getValidSimpleViewAuthorDto() {
    return SimpleViewAuthorDto.builder()
        .firstName(VALID_FIRST_NAME)
        .lastName(VALID_LAST_NAME)
        .bio(VALID_BIO)
        .build();
  }

  public static Author getAuthor() {
    return Author.builder()
        .firstName(VALID_FIRST_NAME)
        .lastName(VALID_LAST_NAME)
        .bio(VALID_BIO)
        .id(UUID.fromString(AUTHOR_ID))
        .build();
  }

  public static SaveAuthorDto getValidSaveAuthorDto(){
    return SaveAuthorDto.builder()
        .firstName(VALID_FIRST_NAME)
        .lastName(VALID_LAST_NAME)
        .bio(VALID_BIO)
        .build();
  }

  public static SaveAuthorDto getInvalidSaveAuthorDto(){
    return SaveAuthorDto.builder()
        .firstName(INVALID_FIRST_NAME)
        .lastName(INVALID_LAST_NAME)
        .bio(INVALID_BIO)
        .build();
  }

}
