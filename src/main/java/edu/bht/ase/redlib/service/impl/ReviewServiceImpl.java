package edu.bht.ase.redlib.service.impl;

import edu.bht.ase.redlib.dto.ReviewDto;
import edu.bht.ase.redlib.mapper.ReviewMapper;
import edu.bht.ase.redlib.repository.ReviewRepository;
import edu.bht.ase.redlib.service.interfaces.BookService;
import edu.bht.ase.redlib.service.interfaces.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final BookService bookService;
    private final ReviewRepository reviewRepository;
    private static final ReviewMapper reviewMapper = ReviewMapper.INSTANCE;

    @Override
    public ReviewDto createReview(String bookId, ReviewDto reviewDto) {
        var review = reviewMapper.reviewDtoToReview(reviewDto);

        bookService.checkIfBookExists(bookId);
        review.setBookId(bookId);

        review.setId(UUID.randomUUID().toString());
        review = reviewRepository.save(review);
        return reviewMapper.reviewToReviewDto(review);
    }

    @Override
    public List<ReviewDto> findReviewsByBookId(String id) {
        return reviewRepository
                .findAllByBookId(id)
                .stream().map(reviewMapper::reviewToReviewDto).toList();
    }
}
