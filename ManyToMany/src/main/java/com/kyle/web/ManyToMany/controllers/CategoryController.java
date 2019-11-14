package com.kyle.web.ManyToMany.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kyle.web.ManyToMany.models.Category;
import com.kyle.web.ManyToMany.models.Product;
import com.kyle.web.ManyToMany.services.CategoryService;
import com.kyle.web.ManyToMany.services.ProductService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    CategoryService categoryService;
    ProductService productService;
    public CategoryController(CategoryService categoryService, ProductService productService){
        this.categoryService = categoryService;
        this.productService = productService;
    }
    @RequestMapping("/new")
    public String newCategoryPage(@ModelAttribute Category category){
        return "NewCategory.jsp";
    }
    @PostMapping("/new")
    public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result){
        if(result.hasErrors()){
            return "NewCategory.jsp";
        }else{
            categoryService.saveCategory(category);
            return "redirect:/categories/"+category.getId();
        }
    }
    @RequestMapping("/{id}")
    public String getCategory(@PathVariable("id") Long id, Model model){
        //get category by id
        Category category = categoryService.findOne(id);
        //find products by category
        //add to model

//        model.addAttribute("products", products);
        Iterable<Product> products = productService.availableProductsForCategory(category);
        model.addAttribute("category", category);
        model.addAttribute("products", products);
        return "ShowCategory.jsp";

    }
    @PostMapping("/addproduct")
    public String addProduct(@RequestParam("categoryId") Long catId, @RequestParam("productVal") Long productId){
        Product product = productService.findOne(productId);
        Category category = categoryService.findOne(catId);
        List<Product> products = category.getProducts();
        products.add(product);
        category.setProducts(products);
        categoryService.saveCategory(category);
        return "redirect:/categories/"+category.getId();
    }
}