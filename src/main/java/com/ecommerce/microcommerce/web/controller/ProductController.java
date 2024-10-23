package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.dao.ProductDaoI;
import com.ecommerce.microcommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductDaoI productDao;

    // Get all products
    @GetMapping("/products")
    public List<Product> listProducts() {
        return productDao.findAll();
    }

    // Get a product by ID
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable int id) {
        return productDao.findById(id);
    }

    // Add a product
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productDao.save(product);
    }

    // Update a product
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        Product existingProduct = productDao.findById(id);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            productDao.save(existingProduct);
        }
        return existingProduct;
    }

    // Delete a product
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id) {
        Product product = productDao.findById(id);
        if (product != null) {
            productDao.findAll().remove(product);
        }
    }
}
