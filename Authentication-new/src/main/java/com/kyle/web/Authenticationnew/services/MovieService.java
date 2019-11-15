package com.kyle.web.Authenticationnew.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kyle.web.Authentiactionnew.models.Movie;
import com.kyle.web.Authenticationnew.repositories.MovieRepository;

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
