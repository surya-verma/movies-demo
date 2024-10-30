package com.example.demo.movies.controller;

import com.example.demo.movies.dto.ReviewRequest;
import com.example.demo.movies.entity.Movie;
import com.example.demo.movies.entity.Review;
import com.example.demo.movies.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/movies/{movie_id}/review")
    ResponseEntity createRating(@PathVariable(value = "movie_id") Long movieId, @RequestBody ReviewRequest reviewRequest) {
        Review review = reviewService.postReview(movieId, reviewRequest);
        return ResponseEntity.ok(review);
    }

    @GetMapping("/movies/{movie_id}/reviews")
    ResponseEntity<List<Review>> getRatings(@PathVariable(value = "movie_id") Long movieId){
        List<Review> review = reviewService.getAllReviews(movieId);
        return ResponseEntity.ok(review);
    }
}
