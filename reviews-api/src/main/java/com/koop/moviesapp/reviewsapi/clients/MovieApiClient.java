package com.koop.moviesapp.reviewsapi.clients;

import com.koop.moviesapp.reviewsapi.clients.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient("movie-api/movies")
public interface MovieApiClient {
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable("id") Integer id);
}
