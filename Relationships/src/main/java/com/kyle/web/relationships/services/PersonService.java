package com.kyle.web.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kyle.web.relationships.models.Person;
import com.kyle.web.relationships.repositories.PersonRepository;



@Service
public class PersonService {
	private final PersonRepository repo;
	
	public PersonService(PersonRepository repo) {
		this.repo = repo;
	} 

	public List<Person> getAll() {
        return (List<Person>) repo.findAll();
    }
	public Iterable<Person> getNullLicensePersons(){
        return repo.findAllByLicenseIsNull();
    }
	
    public Person update(Person p) {
        return repo.save(p);

	}

	public void delete(Long x) {
		repo.deleteById(x);
		return;
	}
	
    public Person create(Person p) {
        return repo.save(p);
    }

    public Person findOne(Long id) {
        Optional<Person> opt = repo.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        } else {
            return null;
        }
    }

}

