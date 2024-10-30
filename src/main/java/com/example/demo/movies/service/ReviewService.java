package com.example.demo.movies.service;

import com.example.demo.movies.dto.ReviewRequest;
import com.example.demo.movies.entity.Review;

import java.util.List;

public interface ReviewService {

   Review postReview(Long movieId, ReviewRequest reviewRequest);

   List<Review> getAllReviews(Long movieId);
}
