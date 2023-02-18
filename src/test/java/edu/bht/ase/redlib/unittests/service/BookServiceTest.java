package edu.bht.ase.redlib.unittests.service;

import edu.bht.ase.redlib.exception.codes.CatalogueExceptionCodes;
import edu.bht.ase.redlib.exception.ex.EntityNotFoundException;
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
import java.util.Optional;
import java.util.Set;

import static edu.bht.ase.redlib.testdata.TestData.TEST_AUTHOR_ID;
import static edu.bht.ase.redlib.testdata.TestData.TEST_BOOK_ID;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {
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

    @Test
    void should_ThrowNotFoundException_When_AuthorsNotFoundDuringBookCreation() {
        var bookDto = BookDtoTestData.aBookDto();
        when(authorService.getAuthorsByIds(Set.of(TEST_AUTHOR_ID))).thenReturn(List.of());

        String expectedReasonCode = CatalogueExceptionCodes.AUTHOR_DOES_NOT_EXIST.reasonCode;
        String expectedReasonDescription = "Author with id authorid does not exist";
        Assertions.assertThatThrownBy(() -> bookService.createBook(bookDto))
                .isInstanceOf(EntityNotFoundException.class)
                .matches(x -> expectedReasonCode.equals(((EntityNotFoundException) x).getReasonCode()))
                .matches(x -> expectedReasonDescription.equals(((EntityNotFoundException) x).getReasonDescription()));
    }

    @Test
    void should_ReturnBook_When_BookFound() {
        when(bookRepository.findById(TEST_BOOK_ID)).thenReturn(Optional.of(BookTestData.aBook()));

        var book = bookService.findBookById(TEST_BOOK_ID);

        Assertions.assertThat(book).usingRecursiveComparison().isEqualTo(BookDtoTestData.aBookDto());
    }

    @Test
    void should_ThrowNotFoundException_When_BookNotFound() {
        when(bookRepository.findById(TEST_BOOK_ID)).thenReturn(Optional.empty());

        String expectedReasonCode = CatalogueExceptionCodes.BOOK_DOES_NOT_EXIST.reasonCode;
        String expectedReasonDescription = "Book with id bookid does not exist";
        Assertions.assertThatThrownBy(() -> bookService.findBookById(TEST_BOOK_ID))
                .isInstanceOf(EntityNotFoundException.class)
                .matches(x -> expectedReasonCode.equals(((EntityNotFoundException) x).getReasonCode()))
                .matches(x -> expectedReasonDescription.equals(((EntityNotFoundException) x).getReasonDescription()));
    }

    @Test
    void should_NotRaiseExceptions_When_BookExists() {
        when(bookRepository.existsById(TEST_BOOK_ID)).thenReturn(true);

        bookService.checkIfBookExists(TEST_BOOK_ID);
    }

    @Test
    void should_ThrowNotFoundException_When_BookDoesntExist() {
        when(bookRepository.existsById(TEST_BOOK_ID)).thenReturn(false);

        String expectedReasonCode = CatalogueExceptionCodes.BOOK_DOES_NOT_EXIST.reasonCode;
        String expectedReasonDescription = "Book with id bookid does not exist";
        Assertions.assertThatThrownBy(() -> bookService.checkIfBookExists(TEST_BOOK_ID))
                .isInstanceOf(EntityNotFoundException.class)
                .matches(x -> expectedReasonCode.equals(((EntityNotFoundException) x).getReasonCode()))
                .matches(x -> expectedReasonDescription.equals(((EntityNotFoundException) x).getReasonDescription()));
    }
}
