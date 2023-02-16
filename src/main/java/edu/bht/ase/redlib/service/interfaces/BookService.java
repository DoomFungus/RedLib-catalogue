package edu.bht.ase.redlib.service.interfaces;

import edu.bht.ase.redlib.dto.BookDto;
import edu.bht.ase.redlib.model.Book;

public interface BookService {
    Book getBookById(String id);
    BookDto findBookById(String id);

    BookDto createBook(BookDto bookDto);
}
