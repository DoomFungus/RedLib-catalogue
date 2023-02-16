package edu.bht.ase.redlib.repository;

import edu.bht.ase.redlib.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
}
