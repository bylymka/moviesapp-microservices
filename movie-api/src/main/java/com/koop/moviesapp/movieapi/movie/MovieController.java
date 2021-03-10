package com.koop.moviesapp.movieapi.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody @Valid MovieDto movie) {
        if(movie == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Movie persisted = movieService.createMovie(movie);
        return new ResponseEntity<>(persisted, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable("id") Integer id) {
        if(id == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Movie movie = movieService.getMovie(id);

        if(movie == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(movie, HttpStatus.OK);
    }
}
