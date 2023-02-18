package edu.bht.ase.redlib.testdata.entity;

import edu.bht.ase.redlib.model.Review;

import static edu.bht.ase.redlib.testdata.TestData.*;

public class ReviewTestData {
    public static Review aReview() {
        var review = new Review();
        review.setId(TEST_REVIEW_ID);
        review.setUsername(TEST_REVIEW_USERNAME);
        review.setText(TEST_REVIEW_TEXT);
        review.setRating(TEST_REVIEW_RATING);
        return review;
    }
}
