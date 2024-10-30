package com.example.demo.movies.service;

import com.example.demo.movies.dto.MovieRequest;
import com.example.demo.movies.dto.SearchArgs;
import com.example.demo.movies.entity.Movie;
import com.example.demo.movies.exception.ResourceAlreadyExists;
import com.example.demo.movies.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {

    Movie save(MovieRequest movie) throws ResourceAlreadyExists;

    List<Movie> getAllMovies(SearchArgs searchArgs);

    Movie getMovieById(Long id) throws ResourceNotFoundException;
}
