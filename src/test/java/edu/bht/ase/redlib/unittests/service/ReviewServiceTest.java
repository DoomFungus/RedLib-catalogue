package edu.bht.ase.redlib.unittests.service;

import edu.bht.ase.redlib.model.Review;
import edu.bht.ase.redlib.repository.ReviewRepository;
import edu.bht.ase.redlib.service.impl.ReviewServiceImpl;
import edu.bht.ase.redlib.service.interfaces.BookService;
import edu.bht.ase.redlib.testdata.dto.ReviewDtoTestData;
import edu.bht.ase.redlib.testdata.entity.ReviewTestData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static edu.bht.ase.redlib.testdata.TestData.TEST_BOOK_ID;

@ExtendWith(MockitoExtension.class)
class ReviewServiceTest {
    @InjectMocks
    private ReviewServiceImpl reviewService;
    @Mock
    private BookService bookService;
    @Spy
    private ReviewRepository reviewRepository;

    @Test
    void should_SaveReview_When_CreatingReview() {
        var reviewDto = ReviewDtoTestData.aReviewDto();

        reviewService.createReview(TEST_BOOK_ID, reviewDto);

        ArgumentCaptor<Review> argument = ArgumentCaptor.forClass(Review.class);
        Mockito.verify(reviewRepository).save(argument.capture());
        Assertions.assertThat(argument.getValue())
                .usingRecursiveComparison()
                .ignoringFields("id", "bookId")
                .isEqualTo(ReviewTestData.aReview());
    }

    @Test
    void should_SaveCorrectBookId_When_CreatingReview() {
        var reviewDto = ReviewDtoTestData.aReviewDto();

        reviewService.createReview(TEST_BOOK_ID, reviewDto);

        ArgumentCaptor<Review> argument = ArgumentCaptor.forClass(Review.class);
        Mockito.verify(reviewRepository).save(argument.capture());
        Assertions.assertThat(argument.getValue().getBookId())
                .isEqualTo(TEST_BOOK_ID);
    }

    @Test
    void should_OverwriteIdWithUUID_When_CreatingReview() {
        var reviewDto = ReviewDtoTestData.aReviewDto();

        reviewService.createReview(TEST_BOOK_ID, reviewDto);

        ArgumentCaptor<Review> argument = ArgumentCaptor.forClass(Review.class);
        Mockito.verify(reviewRepository).save(argument.capture());
        Assertions.assertThat(argument.getValue().getId())
                .matches(s -> s.matches("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$"));
    }
}
