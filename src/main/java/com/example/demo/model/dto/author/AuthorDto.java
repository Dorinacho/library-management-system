package com.example.demo.model.dto.author;

import jakarta.validation.constraints.NotBlank;
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
public class AuthorDto {

  @NotBlank(message = "First name cannot be null")
  private String firstName;

  @NotBlank(message = "Last name cannot be null")
  private String lastName;

  @Length(max = 255, message = "Bio shouldn't be longer than 255 characters")
  private String bio;
}
