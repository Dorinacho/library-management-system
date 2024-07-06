package com.example.demo.service.impl;

import com.example.demo.mapper.BookMapper;
import com.example.demo.model.dto.BookDto;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;
  private final BookMapper bookMapper;

  @Override
  public List<BookDto> getAllBooks() {
    return bookRepository.findAll().stream()
        .map(bookMapper::toBookDto)
        .toList();
  }
}
