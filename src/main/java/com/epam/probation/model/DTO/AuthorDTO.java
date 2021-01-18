package com.epam.probation.model.DTO;

import com.epam.probation.model.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {

    private Long id;

    private String name;

    private Integer age;

    private List<BookDTO> books;
}
