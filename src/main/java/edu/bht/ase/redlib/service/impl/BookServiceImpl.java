package edu.bht.ase.redlib.service.impl;

import edu.bht.ase.redlib.dto.BookDto;
import edu.bht.ase.redlib.exception.codes.CatalogueExceptionCodes;
import edu.bht.ase.redlib.exception.ex.EntityNotFoundException;
import edu.bht.ase.redlib.mapper.BookMapper;
import edu.bht.ase.redlib.model.Author;
import edu.bht.ase.redlib.repository.BookRepository;
import edu.bht.ase.redlib.service.interfaces.AuthorService;
import edu.bht.ase.redlib.service.interfaces.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final AuthorService authorService;
    private final BookRepository bookRepository;
    private static final BookMapper bookMapper = BookMapper.INSTANCE;

    @Override
    public void checkIfBookExists(String id) {
        if (!bookRepository.existsById(id))
            throw new EntityNotFoundException(CatalogueExceptionCodes.BOOK_DOES_NOT_EXIST, id);
    }

    @Override
    public BookDto findBookById(String id) {
        var book = bookRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(CatalogueExceptionCodes.BOOK_DOES_NOT_EXIST, id));
        return bookMapper.bookToBookDto(book);
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

        book.setId(UUID.randomUUID().toString());
        book = bookRepository.save(book);
        return bookMapper.bookToBookDto(book);
    }
}
