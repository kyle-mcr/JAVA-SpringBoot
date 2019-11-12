package com.kyle.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kyle.web.models.Song;
import com.kyle.web.repositories.SongRepository;

@Service
public class SongService {
	private final SongRepository repo;
	
	public SongService(SongRepository repo) {
		this.repo = repo;
	} 

	public List<Song> getAll() {
        return (List<Song>) repo.findAll();
    }
	
    public Song update(Song s) {
        return repo.save(s);

	}

	public void delete(Long x) {
		repo.deleteById(x);
		return;
	}
	
    public Song create(Song s) {
        return repo.save(s);
    }

    public Song findOne(Long id) {
        Optional<Song> opt = repo.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        } else {
            return null;
        }
    }

}