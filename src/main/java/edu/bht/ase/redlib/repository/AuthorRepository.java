package edu.bht.ase.redlib.repository;

import edu.bht.ase.redlib.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> findAllByIdIn(Collection<Integer> ids);
}
