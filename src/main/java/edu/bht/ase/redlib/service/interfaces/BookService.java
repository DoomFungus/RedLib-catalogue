package edu.bht.ase.redlib.service.interfaces;

import edu.bht.ase.redlib.dto.BookDto;

public interface BookService {
    BookDto getBookById(Integer id);

    BookDto createBook(BookDto bookDto);
}
