package com.company.ProductSpringWeb.controller;

import com.company.ProductSpringWeb.model.Product;
import com.company.ProductSpringWeb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService service;

    //get all products
    @GetMapping("/")
    public List<Product> getAllProducts() {
        return service.getAll();
    }

    //search product by name
    @GetMapping(value = "/name/{name}")
    public Product getProductByName(@PathVariable String name) {
        return service.getProduct(name);
    }

    //search product by id
    @GetMapping(value = "/id/{id}")
    public Optional<Product> getProductById(@PathVariable Integer id) {
        return service.getProductById(id);
    }

    //add new product
    @PostMapping("/new")
    public void addProduct(@RequestBody Product product) {
        service.addProduct(product);
    }

    //update product
    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        return service.updateProduct(id, product);
    }

    //remove product
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        service.deleteProduct(id);
    }

}
