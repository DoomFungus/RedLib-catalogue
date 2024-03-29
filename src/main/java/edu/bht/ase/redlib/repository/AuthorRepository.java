package edu.bht.ase.redlib.repository;

import edu.bht.ase.redlib.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
@Repository
public interface AuthorRepository extends MongoRepository<Author, String> {
    List<Author> findAllByIdIn(Collection<String> ids);
}
