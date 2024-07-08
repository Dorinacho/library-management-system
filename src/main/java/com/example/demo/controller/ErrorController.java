package com.example.demo.controller;

import com.example.demo.dto.ErrorResponseDto;
import com.example.demo.error.ErrorDetails;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {


  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(EntityNotFoundException.class)
  public ErrorResponseDto handleEntityNotFoundException(EntityNotFoundException exception) {
    return ErrorResponseDto.builder()
        .message(exception.getMessage())
        .statusCode(HttpStatus.NOT_FOUND.value())
        .build();
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ErrorResponseDto handleValidationException(MethodArgumentNotValidException exception) {
    List<ErrorDetails> fieldErrors = exception.getFieldErrors().stream()
        .map(fieldError -> ErrorDetails.builder()
            .field(fieldError.getField())
            .message(fieldError.getDefaultMessage())
            .build())
        .toList();

    return ErrorResponseDto.builder()
        .errors(fieldErrors)
        .message(exception.getBody().getDetail())
        .statusCode(exception.getStatusCode().value())
        .build();
  }
}
