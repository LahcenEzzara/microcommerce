package com.ecommerce.microcommerce.controller;

import com.ecommerce.microcommerce.dao.ProductDaoI;
import com.ecommerce.microcommerce.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/products")
public class ProductController {

    private final ProductDaoI productDao;

    public ProductController(ProductDaoI productDao) {
        this.productDao = productDao;
    }

    // Get all products
    @GetMapping
    public List<Product> listProducts() {
        return productDao.findAll();
    }

    // Get a product by ID
    @GetMapping("{id}")
    public Product getProduct(@PathVariable int id) {
        return productDao.findById(id);
    }

    // Add a product
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productDao.save(product);
    }

    // Update a product
    @PutMapping("{id}")
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
    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable int id) {
        Product product = productDao.findById(id);
        if (product != null) {
            productDao.findAll().remove(product);
        }
    }
}
