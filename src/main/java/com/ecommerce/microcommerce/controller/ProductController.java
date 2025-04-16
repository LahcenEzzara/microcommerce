package com.ecommerce.microcommerce.controller;

import com.ecommerce.microcommerce.dao.ProductDaoI;
import com.ecommerce.microcommerce.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductDaoI productDao;

    public ProductController(ProductDaoI productDao) {
        this.productDao = productDao;
    }

    // Get all products
    @GetMapping
    public ResponseEntity<List<Product>> listProducts() {
        List<Product> products = productDao.findAll();
        return ResponseEntity.ok(products);
    }

    // Get a product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        Product product = productDao.findById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    // Add a product
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product savedProduct = productDao.save(product);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedProduct.getId()).toUri();

        return ResponseEntity.created(location).body(savedProduct);
    }

    // Update a product
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product) {
        Product existingProduct = productDao.findById(id);
        if (existingProduct == null) {
            return ResponseEntity.notFound().build();
        }

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        Product updatedProduct = productDao.save(existingProduct);

        return ResponseEntity.ok(updatedProduct);
    }

    // Delete a product
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        Product product = productDao.findById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }

        productDao.delete(product);
        return ResponseEntity.noContent().build();
    }
}