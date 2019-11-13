package com.kyle.web.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kyle.web.relationships.models.License;
import com.kyle.web.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository repo;
	
	public LicenseService(LicenseRepository repo) {
		this.repo = repo;
	} 

	public List<License> getAll() {
        return (List<License>) repo.findAll();
    }
	
    public License update(License l) {
        return repo.save(l);

	}

	public void delete(Long x) {
		repo.deleteById(x);
		return;
	}
	
    public License create(License l) {
        return repo.save(l);
    }

    public License findOne(Long id) {
        Optional<License> opt = repo.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        } else {
            return null;
        }
    }

}

