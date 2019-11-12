package com.kyle.web.lookify.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kyle.web.lookify.models.Song;


	@Repository
	public interface SongRepository extends CrudRepository<Song, Long> {
		
	}