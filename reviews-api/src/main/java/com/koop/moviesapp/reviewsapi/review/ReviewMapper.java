package com.koop.moviesapp.reviewsapi.review;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReviewMapper {
    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    ReviewRequest reviewToReviewRequest(Review review);
    Review reviewRequestToReview(ReviewRequest reviewRequest);
}
