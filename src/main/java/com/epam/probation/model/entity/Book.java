package com.epam.probation.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Builder
@Data
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    public Long id;

    public String name;

    public Integer pages;

    @ManyToOne
    @JoinColumn(name = "author_id")
    public Author author;
}
