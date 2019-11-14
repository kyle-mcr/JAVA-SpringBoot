package com.kyle.web.ManyToMany.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kyle.web.ManyToMany.models.Category;
import com.kyle.web.ManyToMany.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAllByCategoriesEquals(Category category);
    List<Product> findByCategoriesNotContains(Category category);
}