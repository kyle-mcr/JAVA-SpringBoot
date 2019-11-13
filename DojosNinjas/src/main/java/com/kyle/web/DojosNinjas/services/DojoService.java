 package com.kyle.web.DojosNinjas.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kyle.web.DojosNinjas.models.Dojo;
import com.kyle.web.DojosNinjas.repositories.DojoRepository;

@Service
 public class DojoService {
     DojoRepository dojoRepo;
     public DojoService(DojoRepository dojoRepo){
         this.dojoRepo = dojoRepo;
     }
     public void saveDojo(Dojo dojo){
         dojoRepo.save(dojo);
     }
     public Iterable<Dojo> getAll(){
         return dojoRepo.findAll();
     }

	public Dojo findOne(Long id) {
	        Optional<Dojo> opt = dojoRepo.findById(id);
	        if(opt.isPresent()) {
	            return opt.get();
	        } else {
	            return null;
	        }
	    }
	
	}
	
