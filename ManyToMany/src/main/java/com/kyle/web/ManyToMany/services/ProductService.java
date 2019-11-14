package com.kyle.web.ManyToMany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.kyle.web.ManyToMany.models.Category;
import com.kyle.web.ManyToMany.models.Product;
import com.kyle.web.ManyToMany.repositories.ProductRepository;

@Service
public class ProductService {
    ProductRepository productRepo;
    public ProductService(ProductRepository productRepo){
        this.productRepo = productRepo;
    }
    public void saveProduct(Product product){
        productRepo.save(product);
    }
    public List<Product> getByCategory(Category category){
        return productRepo.findAllByCategoriesEquals(category);
    }
 
    public Iterable<Product> availableProductsForCategory(Category category){
        return productRepo.findByCategoriesNotContains(category);
    }
    public Product findOne(Long id) {
        Optional<Product> opt = productRepo.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        } else {
            return null;
        }
    }

}

