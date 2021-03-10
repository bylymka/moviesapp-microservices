package com.koop.moviesapp.movieapi.movie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie createMovie(MovieDto movie) {
        log.info("IN MovieService createMovie {}", movie);
        return movieRepository.save(MovieMapper.INSTANCE.movieDtoToMovie(movie));
    }
    public Movie getMovie(Integer id) {
        log.info("IN MovieService getMovie {}", id);
        Optional<Movie> movie = movieRepository.findById(id);
        return movie.orElse(null);
    }

}
