package edu.bht.ase.redlib.unittests.mapper;

import edu.bht.ase.redlib.mapper.BookMapper;
import edu.bht.ase.redlib.testdata.dto.BookDtoTestData;
import edu.bht.ase.redlib.testdata.entity.BookTestData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BookMapperTest {
    BookMapper bookMapper = BookMapper.INSTANCE;

    @Test
    void should_MapToEntity_When_ProvidedWithCorrectDto(){
        var bookDto = BookDtoTestData.aBookDto();

        var book = bookMapper.bookDtoToBook(bookDto);

        Assertions.assertThat(book).usingRecursiveComparison().isEqualTo(BookTestData.aBook());
    }

    @Test
    void should_MapToDto_When_ProvidedWithCorrectEntity(){
        var book = BookTestData.aBook();

        var bookDto = bookMapper.bookToBookDto(book);

        Assertions.assertThat(bookDto).usingRecursiveComparison().isEqualTo(BookDtoTestData.aBookDto());
    }
}
