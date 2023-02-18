package edu.bht.ase.redlib.testdata.entity;

import edu.bht.ase.redlib.model.Book;

import java.util.List;

import static edu.bht.ase.redlib.testdata.TestData.*;

public class BookTestData {
    public static Book aBook() {
        var book = new Book();
        book.setId(TEST_BOOK_ID);
        book.setName(TEST_BOOK_NAME);
        book.setSummary(TEST_BOOK_SUMMARY);
        book.setAuthors(List.of(AuthorTestData.anAuthor()));
        book.setTags(List.of(TEST_BOOK_TAG));
        return book;
    }
}
