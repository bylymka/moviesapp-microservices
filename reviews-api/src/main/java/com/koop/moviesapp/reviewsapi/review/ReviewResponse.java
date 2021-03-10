package com.koop.moviesapp.reviewsapi.review;

import com.koop.moviesapp.reviewsapi.clients.model.MovieDto;
import com.koop.moviesapp.reviewsapi.clients.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ReviewResponse {
    private String email;
    private String firstName;
    private String lastName;
    private List<MovieDto> movies;

    public ReviewResponse(User user, List<MovieDto> movies) {
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.movies = movies;
    }
}
