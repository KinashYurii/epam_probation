package com.epam.probation.service.impl;

import com.epam.probation.DAO.BookRepository;
import com.epam.probation.exception.BookNotFoundException;
import com.epam.probation.model.DTO.BookDTO;
import com.epam.probation.model.entity.Book;
import com.epam.probation.model.mapper.BookMapper;
import com.epam.probation.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDTO getById(Long id) throws BookNotFoundException {
        return BookMapper.modelToDTO(
                bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book", id)));
    }

    @Override
    public List<BookDTO> getAll() {
        return BookMapper.modelToDTOs(bookRepository.findAll());
    }

    @Override
    public BookDTO save(Book book) {
        return BookMapper.modelToDTO(bookRepository.save(book));
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
