package edu.bht.ase.redlib.unittests.mapper;

import edu.bht.ase.redlib.mapper.AuthorMapper;
import edu.bht.ase.redlib.testdata.dto.AuthorDtoTestData;
import edu.bht.ase.redlib.testdata.entity.AuthorTestData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AuthorMapperTest {
    AuthorMapper authorMapper = AuthorMapper.INSTANCE;

    @Test
    void should_MapToEntity_When_ProvidedWithCorrectDto() {
        var authorDto = AuthorDtoTestData.anAuthorDto();

        var author = authorMapper.authorDtoToAuthor(authorDto);

        Assertions.assertThat(author).usingRecursiveComparison().isEqualTo(AuthorTestData.anAuthor());
    }

    @Test
    void should_MapToDto_When_ProvidedWithCorrectEntity() {
        var author = AuthorTestData.anAuthor();

        var authorDto = authorMapper.authorToAuthorDto(author);

        Assertions.assertThat(authorDto).usingRecursiveComparison().isEqualTo(AuthorDtoTestData.anAuthorDto());
    }
}
