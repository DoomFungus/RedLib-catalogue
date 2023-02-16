package edu.bht.ase.redlib.service.interfaces;

import edu.bht.ase.redlib.dto.AuthorDto;
import edu.bht.ase.redlib.model.Author;

import java.util.Collection;
import java.util.List;

public interface AuthorService {
    List<Author> getAuthorsByIds(Collection<String> ids);

    AuthorDto findAuthorById(String id);

    AuthorDto createAuthor(AuthorDto authorDto);
}
