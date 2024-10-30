package com.example.demo.movies.controller;

import com.example.demo.movies.dto.MovieRequest;
import com.example.demo.movies.dto.SearchArgs;
import com.example.demo.movies.entity.Movie;
import com.example.demo.movies.exception.ResourceAlreadyExists;
import com.example.demo.movies.exception.ResourceNotFoundException;
import com.example.demo.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/movies/movie")
    public ResponseEntity createMovie(@RequestBody MovieRequest movie){
        try {
            Movie movieEntity = movieService.save(movie);
            return ResponseEntity.ok(movieEntity);
        }catch (ResourceAlreadyExists e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PutMapping("/movies/search")
    ResponseEntity<List<Movie>> searchMovie(@RequestBody SearchArgs searchArgs){
        List<Movie> movieList = movieService.getAllMovies(searchArgs);
        return ResponseEntity.ok(movieList);
    }

    @GetMapping("/movies")
    ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movieList = movieService.getAllMovies(null);
        return ResponseEntity.ok(movieList);
    }

    @GetMapping("/movies/{movie_id}")
    ResponseEntity getMovieById(@PathVariable(value = "movie_id") Long movieId){
        Movie movie = null;
        try {
            movie = movieService.getMovieById(movieId);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.ok(movie);
    }
}
