package com.example.demo.movies.service;

import com.example.demo.movies.dto.ReviewRequest;
import com.example.demo.movies.entity.Movie;
import com.example.demo.movies.entity.Review;
import com.example.demo.movies.repository.MovieRepository;
import com.example.demo.movies.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private final MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Review postReview(Long movieId, ReviewRequest reviewRequest) {
        Review review = new Review();
        //check if movie id is valid
        Optional<Movie> movie = movieRepository.findById(movieId);
        if(movie.isPresent()) {
            review.setMovie(movie.get());
            review.setContent(reviewRequest.getContent());
            review.setMovieRating(reviewRequest.getMovieRating());
            review.setSubmitterName(reviewRequest.getSubmitterName());
            Calendar calendar = Calendar.getInstance();
            //Returns current time in millis
            long timeInMillis = calendar.getTimeInMillis();
            review.setDateTimeMilli(timeInMillis);
            Review reviewNew = reviewRepository.save(review);
            //calculate average rating and update to movie table
            Double rating = reviewRepository.getAverageRating(movieId);
            movie.get().setRating(rating);
            movieRepository.save(movie.get());
            return reviewNew;
        }else {
            throw new IllegalArgumentException("Movie not found");
        }
    }

    @Override
    public List<Review> getAllReviews(Long movieId) {
        List<Review> reviews = reviewRepository.findByMovieId(movieId);
        return reviews;
    }
}
