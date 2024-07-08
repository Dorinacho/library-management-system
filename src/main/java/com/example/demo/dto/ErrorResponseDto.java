package com.example.demo.dto;

import com.example.demo.error.ErrorDetails;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponseDto {

  private int statusCode;
  private String message;
  private List<ErrorDetails> errors;
}
