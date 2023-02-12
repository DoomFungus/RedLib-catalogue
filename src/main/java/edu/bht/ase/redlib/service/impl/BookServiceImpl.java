package edu.bht.ase.redlib.service.impl;

import edu.bht.ase.redlib.dto.BookDto;
import edu.bht.ase.redlib.exception.codes.CatalogueExceptionCodes;
import edu.bht.ase.redlib.exception.ex.EntityNotFoundException;
import edu.bht.ase.redlib.mapper.BookMapper;
import edu.bht.ase.redlib.model.Author;
import edu.bht.ase.redlib.model.Book;
import edu.bht.ase.redlib.repository.BookRepository;
import edu.bht.ase.redlib.service.interfaces.AuthorService;
import edu.bht.ase.redlib.service.interfaces.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final AuthorService authorService;
    private final BookRepository bookRepository;
    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @Override
    public Book getBookById(Integer id) {
        return bookRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(CatalogueExceptionCodes.BOOK_DOES_NOT_EXIST));
    }

    @Override
    public BookDto findBookById(Integer id) {
        return bookMapper.bookToBookDto(getBookById(id));
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        var book = bookMapper.bookDtoToBook(bookDto);

        var authorIds = book.getAuthors()
                .stream()
                .map(Author::getId)
                .collect(Collectors.toSet());
        var authors = authorService.getAuthorsByIds(authorIds);
        var foundAuthorIds = authors.stream()
                .map(Author::getId)
                .collect(Collectors.toSet());
        authorIds.removeAll(foundAuthorIds);
        if (!authorIds.isEmpty()) {
            throw new EntityNotFoundException(CatalogueExceptionCodes.AUTHOR_DOES_NOT_EXIST,
                    authorIds.stream().findFirst().get());
        }

        book.setAuthors(authors);
        book = bookRepository.save(book);
        return bookMapper.bookToBookDto(book);
    }
}
