package com.kyle.web.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kyle.web.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	
}