package com.epam.probation.model.DTO;

import com.epam.probation.model.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
@AllArgsConstructor
public class AuthorDTO {

    private Long id;

    private String name;

    private Integer age;

    private Set<Book> books;
}
