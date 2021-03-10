package com.koop.moviesapp.reviewsapi.review;

import com.koop.moviesapp.reviewsapi.clients.MovieApiClient;
import com.koop.moviesapp.reviewsapi.clients.UsersApiClient;
import com.koop.moviesapp.reviewsapi.clients.model.Movie;
import com.koop.moviesapp.reviewsapi.clients.model.MovieDto;
import com.koop.moviesapp.reviewsapi.clients.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UsersApiClient usersApiClient;
    private final MovieApiClient movieApiClient;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, UsersApiClient usersApiClient, MovieApiClient movieApiClient) {
        this.reviewRepository = reviewRepository;
        this.usersApiClient = usersApiClient;
        this.movieApiClient = movieApiClient;
    }

    public Review addReview(ReviewRequest reviewRequest) {
        log.info("IN ReviewService addReview {}", reviewRequest);
        return reviewRepository.save(ReviewMapper.INSTANCE.reviewRequestToReview(reviewRequest));
    }

    public ReviewResponse getReviewsByUserId(Integer userId) {
        log.info("IN ReviewService getReviewsByUserId {}", userId);
        return convertReviewsToReviewResponse(reviewRepository.findByUserId(userId));
    }

    private ReviewResponse convertReviewsToReviewResponse(List<Review> reviews) {
        if(reviews.isEmpty())
            return null;

        List<MovieDto> movies = new ArrayList<>();
        User user = usersApiClient.getUser(reviews.get(0).getUserId()).getBody();

        for(Review review: reviews) {
            Movie movie = movieApiClient.getMovie(review.getMovieId()).getBody();
            movies.add(new MovieDto(movie, review));
        }
        return new ReviewResponse(user, movies);
    }
}
