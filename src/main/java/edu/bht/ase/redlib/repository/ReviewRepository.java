package edu.bht.ase.redlib.repository;

import edu.bht.ase.redlib.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {
    Collection<Review> findAllByBookId(String bookId);
}
