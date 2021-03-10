package com.koop.moviesapp.reviewsapi.clients.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private Integer id;
    private String title;
    private String directorName;
    private LocalDate releaseDate;
}
