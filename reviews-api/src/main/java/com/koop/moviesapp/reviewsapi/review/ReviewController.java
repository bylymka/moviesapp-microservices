package com.koop.moviesapp.reviewsapi.review;

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
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody @Valid ReviewRequest reviewRequest) {
        if(reviewRequest == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Review persisted = reviewService.addReview(reviewRequest);
        return new ResponseEntity<>(persisted, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ReviewResponse> getReviewsByUserId(@PathVariable("userId") Integer userId) {
        if(userId == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        ReviewResponse reviews = reviewService.getReviewsByUserId(userId);

        if(reviews == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
}
