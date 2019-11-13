package com.kyle.web.DojosNinjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kyle.web.DojosNinjas.models.Dojo;
import com.kyle.web.DojosNinjas.models.Ninja;
import com.kyle.web.DojosNinjas.services.DojoService;
import com.kyle.web.DojosNinjas.services.NinjaService;

@Controller
@RequestMapping("/dojos")
public class DojoController {
    DojoService dojoService;
    NinjaService ninjaService;
    public DojoController(DojoService dojoService, NinjaService ninjaService){
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }
    @RequestMapping("/new")
    public String serveDojoForm(@ModelAttribute("dojo")Dojo dojo){
        return "dojo.jsp";
    }
    @PostMapping("/new")
    public String createNewDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result){
        if(result.hasErrors()){
            return "dojo.jsp";
        }else{
            //create dojo
            dojoService.saveDojo(dojo);
            return "redirect:/dojos/"+dojo.getId();
        }
    }
    @RequestMapping("/{id}")
    public String getDojo(@PathVariable("id") Long id, Model model){
        Dojo dojo = dojoService.findOne(id);
        Iterable<Ninja> ninjas = ninjaService.findByDojo(dojo);
        model.addAttribute("ninjas", ninjas);
        model.addAttribute("dojo", dojo.getName());
        return "view.jsp";
    }

    
}