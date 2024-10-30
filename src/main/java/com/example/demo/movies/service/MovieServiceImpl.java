package com.example.demo.movies.service;

import com.example.demo.movies.dto.MovieRequest;
import com.example.demo.movies.dto.SearchArgs;
import com.example.demo.movies.entity.Movie;
import com.example.demo.movies.exception.ResourceAlreadyExists;
import com.example.demo.movies.exception.ResourceNotFoundException;
import com.example.demo.movies.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public Movie save(MovieRequest movieRequest) throws ResourceAlreadyExists {

        SearchArgs searchArgs = new SearchArgs();
        searchArgs.setName(movieRequest.getName());
        List<Movie> movieList = movieRepository.findByName(searchArgs.getName());
        if(CollectionUtils.isEmpty(movieList)) {
            Movie movieEntity = new Movie();
            movieEntity.setName(movieRequest.getName());
            movieEntity.setReleaseDate(movieRequest.getReleaseDate());
            movieEntity.setGenre(movieRequest.getGenre());
            movieEntity.setDescription(movieRequest.getDescription());
            Movie movie = movieRepository.save(movieEntity);
            return movie;
        }else {
            throw new ResourceAlreadyExists("Movie already exists by Name : " + movieRequest.getName());
        }
    }

    @Override
    public List<Movie> getAllMovies(SearchArgs searchArgs) {
        List<Movie> movieList = new ArrayList<>();

        if (null != searchArgs && StringUtils.isNotEmpty(searchArgs.getGenre())) {
            movieList = movieRepository.findByGenre(searchArgs.getGenre());
        } else if (null != searchArgs && StringUtils.isNotEmpty(searchArgs.getName())) {
            movieList = movieRepository.findByName(searchArgs.getName());
        } else {
            movieList = movieRepository.findAll();
        }
        return movieList;
    }

    @Override
    public Movie getMovieById(Long id) throws ResourceNotFoundException {
        Optional<Movie> movie = movieRepository.findById(id);
        if(movie.isPresent()) {
            return movie.get();
        }else {
            throw new ResourceNotFoundException("Movie not found by id : " + id);
        }

    }
}
