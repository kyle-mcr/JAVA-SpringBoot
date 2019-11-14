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
@RequestMapping("/products")
public class ProductController {
    ProductService productService;
    CategoryService categoryService;
    public ProductController(ProductService productService, CategoryService categoryService){
        this.productService = productService;
        this.categoryService = categoryService;
    }
    @RequestMapping("/new")
    public String newProductPage(@ModelAttribute("product") Product product){
        return "NewProduct.jsp";
    }
    @PostMapping("/new")
    public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result){
        if(result.hasErrors()){
            return "NewProduct.jsp";
        }else{
            productService.saveProduct(product);
            return "redirect:/products/"+product.getId();
        }
    }
    @RequestMapping("/{id}")
    public String showProduct(@PathVariable("id") Long id, Model model){
        //get product
        //get categories by product
        Product product = productService.findOne(id);
        Iterable<Category> categories = categoryService.availableCategoriesForProduct(product);
        System.out.println(categories);
        model.addAttribute("categories", categories);
        model.addAttribute("product", product);
        return "ShowProduct.jsp";
    }
    @PostMapping("/addcategory")
    public String addCategory(@RequestParam("categoryVal") Long id, @RequestParam("productId") Long productId, Model model){
        Category category = categoryService.findOne(id);
        Product product = productService.findOne(productId);
        List<Category> categories = product.getCategories();
        categories.add(category);
        product.setCategories(categories);
        productService.saveProduct(product);
        return "redirect:/products/"+product.getId();
    }
}
