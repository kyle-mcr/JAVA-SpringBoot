package com.kyle.web.relationships.controllers;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kyle.web.relationships.models.Person;
import com.kyle.web.relationships.services.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
	private final PersonService serv; 
	
	public PersonController(PersonService serv) {
		this.serv = serv;
	}
	@RequestMapping("/new")
	public String addnew(@ModelAttribute("person")Person person) {
		return "newPerson.jsp";
	}
	
	@PostMapping("/new")
	public String newPerson(@Valid @ModelAttribute("person")Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "newPerson.jsp";
		} else {
			serv.create(person);
			return "redirect:/person/"+person.getId();
		}
	}
	 @RequestMapping("/{id}")
	    public String showOnePerson(@PathVariable("id") Long id, Model model){
	        Person person = serv.findOne(id);
	        if(person == null){
	            return "redirect:/person/new";
	        }else{
	            model.addAttribute("person", person);
	            return "show.jsp";
	        }
	    }
	}
