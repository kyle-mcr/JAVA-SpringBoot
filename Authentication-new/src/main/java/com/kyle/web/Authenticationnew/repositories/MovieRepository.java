package com.kyle.web.Authenticationnew.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kyle.web.Authentiactionnew.models.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long>{
	List<Movie> findAll();
}