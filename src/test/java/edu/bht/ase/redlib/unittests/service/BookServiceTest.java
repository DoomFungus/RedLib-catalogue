package edu.bht.ase.redlib.unittests.service;

import edu.bht.ase.redlib.model.Book;
import edu.bht.ase.redlib.repository.BookRepository;
import edu.bht.ase.redlib.service.impl.BookServiceImpl;
import edu.bht.ase.redlib.service.interfaces.AuthorService;
import edu.bht.ase.redlib.testdata.dto.BookDtoTestData;
import edu.bht.ase.redlib.testdata.entity.AuthorTestData;
import edu.bht.ase.redlib.testdata.entity.BookTestData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static edu.bht.ase.redlib.testdata.TestData.TEST_AUTHOR_ID;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @InjectMocks
    private BookServiceImpl bookService;
    @Spy
    private AuthorService authorService;
    @Spy
    private BookRepository bookRepository;

    @Test
    void should_SaveBook_When_CreatingBook() {
        var bookDto = BookDtoTestData.aBookDto();
        when(authorService.getAuthorsByIds(Set.of(TEST_AUTHOR_ID))).thenReturn(List.of(AuthorTestData.anAuthor()));

        bookService.createBook(bookDto);

        ArgumentCaptor<Book> argument = ArgumentCaptor.forClass(Book.class);
        Mockito.verify(bookRepository).save(argument.capture());
        Assertions.assertThat(argument.getValue())
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(BookTestData.aBook());
    }

    @Test
    void should_OverwriteIdWithUUID_When_CreatingBook() {
        var bookDto = BookDtoTestData.aBookDto();
        when(authorService.getAuthorsByIds(Set.of(TEST_AUTHOR_ID))).thenReturn(List.of(AuthorTestData.anAuthor()));

        bookService.createBook(bookDto);

        ArgumentCaptor<Book> argument = ArgumentCaptor.forClass(Book.class);
        Mockito.verify(bookRepository).save(argument.capture());
        Assertions.assertThat(argument.getValue().getId())
                .matches(s -> s.matches("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$"));
    }
}
