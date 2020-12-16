package com.epam.probation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Set;

@Table(name = "author")
@Builder
@Data
@AllArgsConstructor
public class Author {

    @Id
    public Long id;

    @Column(name = "author_name")
    public String name;

    private Integer age;

//    private Set<BookRef> bookIds;
//
//    public void addBook(Book book) {
//        this.bookIds.add(new BookRef(book.getId()));
//    }
}
