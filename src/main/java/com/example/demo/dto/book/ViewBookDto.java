package com.example.demo.dto.book;

import com.example.demo.dto.author.SimpleViewAuthorDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ViewBookDto {

  private String title;
  private String isbn;
  private String description;
  private SimpleViewAuthorDto author;
}

