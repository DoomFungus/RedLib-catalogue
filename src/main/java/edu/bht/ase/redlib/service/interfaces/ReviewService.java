package edu.bht.ase.redlib.service.interfaces;

import edu.bht.ase.redlib.dto.ReviewDto;

import java.util.List;


public interface ReviewService {
    List<ReviewDto> findReviewsByBookId(Integer id);

    ReviewDto createReview(Integer bookId, ReviewDto reviewDto);
}
