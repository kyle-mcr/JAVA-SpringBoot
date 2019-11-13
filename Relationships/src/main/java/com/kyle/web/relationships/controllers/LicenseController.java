package com.kyle.web.relationships.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kyle.web.relationships.models.License;
import com.kyle.web.relationships.models.Person;
import com.kyle.web.relationships.services.LicenseService;
import com.kyle.web.relationships.services.PersonService;



@Controller
@RequestMapping("/license")
public class LicenseController {
	LicenseService licenseService;
	 PersonService personService;
	 
	public LicenseController(LicenseService licenseService, PersonService personService) {
        this.licenseService = licenseService;
        this.personService = personService;
	}
	@RequestMapping("/new")
    public String showNewLicense(@ModelAttribute("license") License license, Model model){
        Iterable<Person> persons = personService.getNullLicensePersons();
        model.addAttribute("persons", persons);
        return "newLicense.jsp";
    }
	
	@PostMapping("/new")
	public String newLicense(@Valid @ModelAttribute("license")License license, BindingResult result) {
		if(result.hasErrors()) {
			return "newLicense.jsp";
		} else {
			licenseService.create(license);
			return "redirect:/person/"+license.getPerson().getId();
		}
	}
}