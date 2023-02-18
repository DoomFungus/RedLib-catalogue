package edu.bht.ase.redlib.testdata.dto;

import edu.bht.ase.redlib.dto.BookDto;

import java.util.List;

import static edu.bht.ase.redlib.testdata.TestData.*;

public class BookDtoTestData {
    public static BookDto aBookDto() {
        var bookDto = new BookDto();
        bookDto.setId(TEST_BOOK_ID);
        bookDto.setName(TEST_BOOK_NAME);
        bookDto.setSummary(TEST_BOOK_SUMMARY);
        bookDto.setAuthors(List.of(AuthorDtoTestData.anAuthorDto()));
        bookDto.setTags(List.of(TEST_BOOK_TAG));
        return bookDto;
    }
}
