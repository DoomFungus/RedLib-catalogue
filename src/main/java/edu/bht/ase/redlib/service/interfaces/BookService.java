package edu.bht.ase.redlib.service.interfaces;

import edu.bht.ase.redlib.dto.BookDto;

public interface BookService {
    BookDto findBookById(Integer id);

    BookDto createBook(BookDto bookDto);
}
