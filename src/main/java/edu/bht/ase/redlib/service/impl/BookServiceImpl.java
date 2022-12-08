package edu.bht.ase.redlib.service.impl;

import edu.bht.ase.redlib.dto.BookDto;
import edu.bht.ase.redlib.mapper.BookMapper;
import edu.bht.ase.redlib.model.Author;
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
    public BookDto findBookById(Integer id) {
        var book = bookRepository.findById(id).get();
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
        if (!foundAuthorIds.containsAll(authorIds)) {
            throw new RuntimeException();
        }

        book.setAuthors(authors);
        book = bookRepository.save(book);
        return bookMapper.bookToBookDto(book);
    }
}
