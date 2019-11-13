package com.kyle.web.DojosNinjas.services;

import org.springframework.stereotype.Service;

import com.kyle.web.DojosNinjas.models.Dojo;
import com.kyle.web.DojosNinjas.models.Ninja;
import com.kyle.web.DojosNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {
    NinjaRepository ninjaRepo;
    public NinjaService(NinjaRepository ninjaRepo){
        this.ninjaRepo = ninjaRepo;
    }
    public void saveNinja(Ninja ninja){
        ninjaRepo.save(ninja);
    }
    public Iterable<Ninja> findByDojo(Dojo dojo){
        Iterable<Ninja> ninjas = ninjaRepo.findAllByDojo(dojo);
        return ninjas;
    }
}
