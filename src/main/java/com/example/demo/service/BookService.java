package com.example.demo.service;

import com.example.demo.model.dto.BookDto;
import java.util.List;

public interface BookService {

  List<BookDto> getAllBooks();
}
