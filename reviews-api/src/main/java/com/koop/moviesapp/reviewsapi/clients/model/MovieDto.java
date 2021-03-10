package com.koop.moviesapp.reviewsapi.clients.model;

import com.koop.moviesapp.reviewsapi.clients.model.Movie;
import com.koop.moviesapp.reviewsapi.review.Review;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class MovieDto {
    private String title;
    private String directorName;
    private LocalDate releaseDate;
    private Integer userRating;
    private String userComment;

    public MovieDto(Movie movie, Review review) {
        this.title = movie.getTitle();
        this.directorName = movie.getDirectorName();
        this.releaseDate = movie.getReleaseDate();
        this.userRating = review.getRating();
        this.userComment = review.getComment();
    }
}
