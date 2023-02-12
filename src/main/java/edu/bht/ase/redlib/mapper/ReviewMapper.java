package edu.bht.ase.redlib.mapper;

import edu.bht.ase.redlib.dto.ReviewDto;
import edu.bht.ase.redlib.model.Review;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = AuthorMapper.class)
public interface ReviewMapper {
    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    ReviewDto reviewToReviewDto(Review review);

    Review reviewDtoToReview(ReviewDto reviewDto);
}
