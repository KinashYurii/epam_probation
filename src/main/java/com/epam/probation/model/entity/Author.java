package com.epam.probation.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "author")
@Builder
@Data
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    private Long id;

    private String name;

    private Integer age;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Book> books;
}
