package com.epam.probation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "book")
@Builder
@Data
@AllArgsConstructor
public class Book {

    @Id
    public Long id;

    @Column(name = "book_name")
    public String name;

    public Integer pages;
}
