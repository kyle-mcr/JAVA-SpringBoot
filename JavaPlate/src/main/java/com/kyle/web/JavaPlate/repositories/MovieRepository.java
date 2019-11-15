package com.kyle.web.JavaPlate.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kyle.web.JavaPlate.models.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long>{
	List<Movie> findAll();
}