package com.kyle.web.JavaPlate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kyle.web.JavaPlate.models.Movie;
import com.kyle.web.JavaPlate.repositories.MovieRepository;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    
    // register user and hash their password
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }
    public List<Movie> findAllMovies(){
    	return movieRepository.findAll();
    }
    
    public Movie findMovieById(Long id) {
    	Optional<Movie> u = movieRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    // authenticate user
    
}
