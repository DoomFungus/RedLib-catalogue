package edu.bht.ase.redlib.service.impl;

import edu.bht.ase.redlib.dto.AuthorDto;
import edu.bht.ase.redlib.mapper.AuthorMapper;
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
    private final AuthorMapper authorMapper = AuthorMapper.INSTANCE;

    @Override
    public List<Author> getAuthorsByIds(Collection<Integer> ids) {
        return authorRepository.findAllByIdIn(ids);
    }

    @Override
    public AuthorDto findAuthorById(Integer id) {
        var author = authorRepository.findById(id).get();
        return authorMapper.authorToAuthorDto(author);
    }

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        var author = authorMapper.authorDtoToAuthor(authorDto);

        author = authorRepository.save(author);
        return authorMapper.authorToAuthorDto(author);
    }
}
