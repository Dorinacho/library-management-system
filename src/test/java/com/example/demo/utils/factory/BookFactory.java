package com.example.demo.utils.factory;

import static com.example.demo.utils.TestConstants.AUTHOR_ID;
import static com.example.demo.utils.TestConstants.INVALID_DESCRIPTION;
import static com.example.demo.utils.TestConstants.INVALID_ISBN;
import static com.example.demo.utils.TestConstants.INVALID_TITLE;
import static com.example.demo.utils.TestConstants.VALID_DESCRIPTION;
import static com.example.demo.utils.TestConstants.VALID_ISBN;
import static com.example.demo.utils.TestConstants.VALID_TITLE;
import static com.example.demo.utils.factory.AuthorFactory.getAuthor;

import com.example.demo.dto.book.SaveBookDto;
import com.example.demo.dto.book.SimpleViewBookDto;
import com.example.demo.entity.Book;
import java.util.UUID;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BookFactory {

  public static SaveBookDto getInvalidSaveBookDto() {
    return SaveBookDto.builder()
        .isbn(INVALID_ISBN)
        .title(INVALID_TITLE)
        .description(INVALID_DESCRIPTION)
        .authorId(UUID.fromString(AUTHOR_ID))
        .build();
  }

  public static SaveBookDto getValidSaveBookDto() {
    return SaveBookDto.builder()
        .isbn(VALID_ISBN)
        .title(VALID_TITLE)
        .description(VALID_DESCRIPTION)
        .authorId(UUID.fromString(AUTHOR_ID))
        .build();
  }

  public static SimpleViewBookDto getValidSimpleViewBookDto() {
    return SimpleViewBookDto.builder()
        .isbn(VALID_ISBN)
        .title(VALID_TITLE)
        .description(VALID_DESCRIPTION)
        .build();
  }

  public static Book getBook() {
    return Book.builder()
        .isbn(VALID_ISBN)
        .title(VALID_TITLE)
        .description(VALID_DESCRIPTION)
        .author(getAuthor())
        .build();
  }
}
