package edu.bht.ase.redlib.testdata.dto;

import edu.bht.ase.redlib.dto.ReviewDto;

import static edu.bht.ase.redlib.testdata.TestData.*;

public class ReviewDtoTestData {
    public static ReviewDto aReviewDto() {
        var reviewDto = new ReviewDto();
        reviewDto.setId(TEST_REVIEW_ID);
        reviewDto.setUsername(TEST_REVIEW_USERNAME);
        reviewDto.setText(TEST_REVIEW_TEXT);
        reviewDto.setRating(TEST_REVIEW_RATING);
        return reviewDto;
    }
}
