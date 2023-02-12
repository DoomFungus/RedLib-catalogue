package edu.bht.ase.redlib.service.impl;

import edu.bht.ase.redlib.dto.ReviewDto;
import edu.bht.ase.redlib.mapper.ReviewMapper;
import edu.bht.ase.redlib.repository.ReviewRepository;
import edu.bht.ase.redlib.service.interfaces.BookService;
import edu.bht.ase.redlib.service.interfaces.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final BookService bookService;
    private final ReviewRepository reviewRepository;
    private static final ReviewMapper reviewMapper = ReviewMapper.INSTANCE;

    @Override
    public ReviewDto createReview(Integer bookId, ReviewDto reviewDto) {
        var review = reviewMapper.reviewDtoToReview(reviewDto);

        var book = bookService.getBookById(bookId);
        review.setBook(book);

        review = reviewRepository.save(review);
        return reviewMapper.reviewToReviewDto(review);
    }

    @Override
    public List<ReviewDto> findReviewsByBookId(Integer id) {
        return reviewRepository
                .findAllByBookId(id)
                .stream().map(reviewMapper::reviewToReviewDto).toList();
    }
}
