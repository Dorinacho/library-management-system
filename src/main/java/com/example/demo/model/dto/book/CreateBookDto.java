package com.example.demo.model.dto.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookDto {

  @NotNull(message = "The book author cannot be null")
  private UUID authorId;

  @NotBlank(message = "The book title cannot be null")
  private String title;

  @Length(min = 17, max = 17, message = "The ISBN should be 17 characters long (including \"-\")")
  @NotBlank(message = "ISBN cannot be null")
  private String isbn;

  @Length(min = 20, max = 255, message = "The book description should be between 20 and 255 characters")
  @NotBlank(message = "The book description cannot be null")
  private String description;

}
