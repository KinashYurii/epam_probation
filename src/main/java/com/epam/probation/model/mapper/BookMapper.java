package com.epam.probation.model.mapper;

import com.epam.probation.model.DTO.BookDTO;
import com.epam.probation.model.entity.Book;

import java.util.List;
import java.util.stream.Collectors;

public class BookMapper {

    public static Book dtoToModel(BookDTO dto) {
        return Book.builder()
                .id(dto.getId())
                .pages(dto.getPages())
                .name(dto.getName())
                .build();
    }

    public static BookDTO modelToDTO(Book model) {
        return BookDTO.builder()
                .id(model.getId())
                .pages(model.getPages())
                .name(model.getName())
                .authorId(model.author.getId())
                .build();
    }

    public static List<Book> dtoToModels(List<BookDTO> dtos) {
        return dtos.stream()
                .map(BookMapper::dtoToModel)
                .collect(Collectors.toList());
    }

    public static List<BookDTO> modelToDTOs(List<Book> models) {
        return models.stream()
                .map(BookMapper::modelToDTO)
                .collect(Collectors.toList());
    }
}
