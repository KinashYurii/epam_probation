package com.epam.probation.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Table;

@Table(name = "author_book")
@Data
@AllArgsConstructor
public class BookRef {
    private Long book;
}
