package com.example.demo.dto.author;

import com.example.demo.dto.book.SimpleViewBookDto;
import java.util.List;
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
public class ViewAuthorDto {

    private String firstName;
    private String lastName;
    private String bio;
    private List<SimpleViewBookDto> books;
}
