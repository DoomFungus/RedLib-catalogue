package edu.bht.ase.redlib.unittests.mapper;

import edu.bht.ase.redlib.mapper.ReviewMapper;
import edu.bht.ase.redlib.testdata.dto.ReviewDtoTestData;
import edu.bht.ase.redlib.testdata.entity.ReviewTestData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ReviewMapperTest {
    ReviewMapper reviewMapper = ReviewMapper.INSTANCE;

    @Test
    void should_MapToEntity_When_ProvidedWithCorrectDto(){
        var reviewDto = ReviewDtoTestData.aReviewDto();

        var review = reviewMapper.reviewDtoToReview(reviewDto);

        Assertions.assertThat(review).usingRecursiveComparison().isEqualTo(ReviewTestData.aReview());
    }

    @Test
    void should_MapToDto_When_ProvidedWithCorrectEntity(){
        var review = ReviewTestData.aReview();

        var reviewDto = reviewMapper.reviewToReviewDto(review);

        Assertions.assertThat(reviewDto).usingRecursiveComparison().isEqualTo(ReviewDtoTestData.aReviewDto());
    }
}
