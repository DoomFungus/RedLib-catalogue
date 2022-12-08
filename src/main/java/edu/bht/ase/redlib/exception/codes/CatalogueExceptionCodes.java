package edu.bht.ase.redlib.exception.codes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CatalogueExceptionCodes implements ExceptionCodes {
    AUTHOR_DOES_NOT_EXIST("CAT-001", "Author with id %d does not exist"),
    BOOK_DOES_NOT_EXIST("CAT-002", "Book with id %d does not exist");
    public final String reasonCode;
    public final String reasonDescription;
}
