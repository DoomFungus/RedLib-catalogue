package edu.bht.ase.redlib.unittests.service;

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

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {
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
}
