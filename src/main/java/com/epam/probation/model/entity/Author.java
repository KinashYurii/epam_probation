package com.epam.probation.model.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

@Entity
@Table(name = "author")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    private Long id;

    private String name;

    private Integer age;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    @BatchSize(size = 100)
    private List<Book> books;
}
