package com.example.demo.movies.repository;

import com.example.demo.movies.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "SELECT AVG(r.movie_rating)  FROM review r WHERE r.movie_id = ?1" , nativeQuery = true)
    double getAverageRating(Long movieId);

    List<Review> findByMovieId(Long movieId);
}
