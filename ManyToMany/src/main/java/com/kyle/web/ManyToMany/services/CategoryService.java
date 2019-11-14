package com.kyle.web.ManyToMany.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kyle.web.ManyToMany.models.Category;
import com.kyle.web.ManyToMany.models.Product;
import com.kyle.web.ManyToMany.repositories.CategoryRepository;

@Service
public class CategoryService {
    CategoryRepository categoryRepo;
    public CategoryService(CategoryRepository categoryRepo){
        this.categoryRepo = categoryRepo;
    }
    public void saveCategory(Category category){
        categoryRepo.save(category);
    }
    public Iterable<Category> availableCategoriesForProduct(Product product){
        return categoryRepo.findByProductsNotContains(product);
    }
    public Category findOne(Long id) {
        Optional<Category> opt = categoryRepo.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        } else {
            return null;
        }
    }
}