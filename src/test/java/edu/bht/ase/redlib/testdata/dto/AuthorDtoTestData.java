package edu.bht.ase.redlib.testdata.dto;

import edu.bht.ase.redlib.dto.AuthorDto;

import static edu.bht.ase.redlib.testdata.TestData.TEST_AUTHOR_ID;
import static edu.bht.ase.redlib.testdata.TestData.TEST_AUTHOR_NAME;

public class AuthorDtoTestData {
    public static AuthorDto anAuthorDto() {
        var authorDto = new AuthorDto();
        authorDto.setId(TEST_AUTHOR_ID);
        authorDto.setName(TEST_AUTHOR_NAME);
        return authorDto;
    }
}
