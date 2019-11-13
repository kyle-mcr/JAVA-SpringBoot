package com.kyle.web.relationships.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kyle.web.relationships.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long>{

}
