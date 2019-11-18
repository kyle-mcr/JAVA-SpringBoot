package com.kyle.web.JavaExam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kyle.web.JavaExam.models.Idea;
import com.kyle.web.JavaExam.repositories.IdeaRepository;


@Service
public class IdeaService {
    private final IdeaRepository ideaRepository;
    
    public IdeaService(IdeaRepository ideaRepository) {
        this.ideaRepository = ideaRepository;
    }
    
    // register user and hash their password
    public Idea createIdea(Idea idea) {
        return ideaRepository.save(idea);
    }
    public List<Idea> findAllIdeas(){
    	return ideaRepository.findAll();
    }
    
    public Idea findIdeaById(Long id) {
    	Optional<Idea> u = ideaRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    // authenticate user
    
}
