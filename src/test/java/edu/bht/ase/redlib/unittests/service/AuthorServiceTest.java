package edu.bht.ase.redlib.unittests.service;

import edu.bht.ase.redlib.exception.codes.CatalogueExceptionCodes;
import edu.bht.ase.redlib.exception.ex.EntityNotFoundException;
import edu.bht.ase.redlib.model.Author;
import edu.bht.ase.redlib.repository.AuthorRepository;
import edu.bht.ase.redlib.service.impl.AuthorServiceImpl;
import edu.bht.ase.redlib.testdata.dto.AuthorDtoTestData;
import edu.bht.ase.redlib.testdata.entity.AuthorTestData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static edu.bht.ase.redlib.testdata.TestData.TEST_AUTHOR_ID;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthorServiceTest {
    @InjectMocks
    private AuthorServiceImpl authorService;
    @Spy
    private AuthorRepository authorRepository;

    @Test
    void should_SaveAuthor_When_CreatingAuthor() {
        var authorDto = AuthorDtoTestData.anAuthorDto();

        authorService.createAuthor(authorDto);

        ArgumentCaptor<Author> argument = ArgumentCaptor.forClass(Author.class);
        Mockito.verify(authorRepository).save(argument.capture());
        Assertions.assertThat(argument.getValue())
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(AuthorTestData.anAuthor());
    }

    @Test
    void should_OverwriteIdWithUUID_When_CreatingAuthor() {
        var authorDto = AuthorDtoTestData.anAuthorDto();

        authorService.createAuthor(authorDto);

        ArgumentCaptor<Author> argument = ArgumentCaptor.forClass(Author.class);
        Mockito.verify(authorRepository).save(argument.capture());
        Assertions.assertThat(argument.getValue().getId())
                .matches(s -> s.matches("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$"));
    }

    @Test
    void should_ThrowNotFoundException_When_AuthorNotFound() {
        when(authorRepository.findById(TEST_AUTHOR_ID)).thenReturn(Optional.empty());

        String expectedReasonCode = CatalogueExceptionCodes.AUTHOR_DOES_NOT_EXIST.reasonCode;
        String expectedReasonDescription = "Author with id authorid does not exist";
        Assertions.assertThatThrownBy(() -> authorService.findAuthorById(TEST_AUTHOR_ID))
                .isInstanceOf(EntityNotFoundException.class)
                .matches(x -> expectedReasonCode.equals(((EntityNotFoundException)x).getReasonCode()))
                .matches(x -> expectedReasonDescription.equals(((EntityNotFoundException)x).getReasonDescription()));
    }
}
