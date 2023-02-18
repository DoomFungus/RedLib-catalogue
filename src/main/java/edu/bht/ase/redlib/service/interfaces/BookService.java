package edu.bht.ase.redlib.service.interfaces;

import edu.bht.ase.redlib.dto.BookDto;

public interface BookService {
    void checkIfBookExists(String id);

    BookDto findBookById(String id);

    BookDto createBook(BookDto bookDto);
}
