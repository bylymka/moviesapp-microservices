package com.koop.moviesapp.movieapi.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    @NotNull
    private String title;
    @NotNull
    private String directorName;
    @NotNull
    private LocalDate releaseDate;
}
