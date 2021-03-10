package com.koop.moviesapp.reviewsapi.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {
    @NotNull
    private Integer userId;
    @NotNull
    private Integer movieId;
    @NotNull
    private Integer rating;
    @NotNull
    private String comment;
}
