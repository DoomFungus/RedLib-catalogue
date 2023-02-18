package edu.bht.ase.redlib.testdata.entity;

import edu.bht.ase.redlib.model.Author;

import static edu.bht.ase.redlib.testdata.TestData.TEST_AUTHOR_ID;
import static edu.bht.ase.redlib.testdata.TestData.TEST_AUTHOR_NAME;

public class AuthorTestData {
    public static Author anAuthor() {
        var author = new Author();
        author.setId(TEST_AUTHOR_ID);
        author.setName(TEST_AUTHOR_NAME);
        return author;
    }
}
