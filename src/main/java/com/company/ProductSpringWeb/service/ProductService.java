package com.company.ProductSpringWeb.service;

import com.company.ProductSpringWeb.repository.ProductDb;
import com.company.ProductSpringWeb.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductDb db;

    public List<Product> getAll() {
        return db.findAll();
    }

    public Product getProduct(String name) {
        return db.findByName(name);
    }

    public void addProduct(Product p) {
        db.save(p);
    }

    public Optional<Product> getProductById(Integer id) {

        return db.findById(id);
    }

    public Product updateProduct(Integer id, Product product) {
        Optional<Product> foundedProduct = db.findById(id);
        if (foundedProduct.isPresent()) {
            Product newProduct = foundedProduct.get();
            newProduct.setName(product.getName());
            newProduct.setType(product.getType());
            newProduct.setPlace(product.getPlace());
            newProduct.setWarranty(product.getWarranty());
            return db.save(newProduct);
        }
        return null;
    }

    public void deleteProduct(Integer id) {
        db.deleteById(id);
    }
}
