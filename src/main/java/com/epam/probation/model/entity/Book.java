package com.epam.probation.model.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {

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
