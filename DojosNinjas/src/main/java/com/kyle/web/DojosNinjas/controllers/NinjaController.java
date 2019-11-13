package com.kyle.web.DojosNinjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kyle.web.DojosNinjas.models.Dojo;
import com.kyle.web.DojosNinjas.models.Ninja;
import com.kyle.web.DojosNinjas.services.DojoService;
import com.kyle.web.DojosNinjas.services.NinjaService;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
    NinjaService ninjaService;
    DojoService dojoService;
    public NinjaController(NinjaService ninjaService, DojoService dojoService){
        this.ninjaService = ninjaService;
        this.dojoService = dojoService;
    }
    @RequestMapping("/new")
    public String serveNewNinjaPage(@ModelAttribute("ninja")Ninja ninja, Model model){
        Iterable<Dojo> dojos = dojoService.getAll();
        model.addAttribute("dojos", dojos);
        return "ninja.jsp";
    }
    @PostMapping("/new")
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model){
        if(result.hasErrors()){
            Iterable<Dojo> dojos = dojoService.getAll();
            model.addAttribute("dojos", dojos);
            return "ninja.jsp";
        }else{
            //create ninja in db
            ninjaService.saveNinja(ninja);
            return "redirect:/dojos/"+ninja.getDojo().getId();
        }
    }
}