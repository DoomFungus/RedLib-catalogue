package edu.bht.ase.redlib.service.impl;

import edu.bht.ase.redlib.model.Author;
import edu.bht.ase.redlib.repository.AuthorRepository;
import edu.bht.ase.redlib.service.interfaces.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public List<Author> getAuthorsByIds(Collection<Integer> ids) {
        return authorRepository.findAllByIdIn(ids);
    }
}
