package com.koop.moviesapp.movieapi.movie;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    MovieDto movieToMovieDto(Movie movie);
    Movie movieDtoToMovie(MovieDto movieDto);
}
