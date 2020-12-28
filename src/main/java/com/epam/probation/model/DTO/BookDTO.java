package com.epam.probation.model.DTO;

import com.epam.probation.model.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class BookDTO {

    public Long id;

    public String name;

    public Integer pages;

    public Author author;
}
