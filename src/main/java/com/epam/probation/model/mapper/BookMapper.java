package com.epam.probation.model.mapper;

import com.epam.probation.model.Book;
import com.epam.probation.model.DTO.BookDTO;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book dtoToModel(BookDTO dto) {
        return Book.builder()
                .id(dto.getId())
                .pages(dto.getPages())
                .name(dto.getName())
                .build();
    }

    public BookDTO modelToDTO(Book model) {
        return BookDTO.builder()
                .id(model.getId())
                .pages(model.getPages())
                .name(model.getName())
                .build();
    }
}
