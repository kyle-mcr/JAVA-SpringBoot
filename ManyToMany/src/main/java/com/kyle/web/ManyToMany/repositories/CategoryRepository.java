package com.kyle.web.ManyToMany.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kyle.web.ManyToMany.models.Category;
import com.kyle.web.ManyToMany.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAllByProductsNot(Product product);
    List<Category> findByProducts(Product product);
    List<Category> findByProductsNot(Product product);
    List<Category> findByProductsNotContains(Product product);

    
}