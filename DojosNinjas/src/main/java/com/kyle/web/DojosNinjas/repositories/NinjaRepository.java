package com.kyle.web.DojosNinjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kyle.web.DojosNinjas.models.Dojo;
import com.kyle.web.DojosNinjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
    List<Ninja> findAllByDojo(Dojo dojo);
}
