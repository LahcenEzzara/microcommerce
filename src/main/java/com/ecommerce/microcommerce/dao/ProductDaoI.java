package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ProductDaoI implements ProductDao {
    private static final List<Product> products = new ArrayList<>();
    private static final AtomicInteger idCounter = new AtomicInteger(20); // Starting after the last ID

    static {
        products.add(new Product(1, "Laptop", 1500));
        products.add(new Product(2, "Smartphone", 800));
        products.add(new Product(3, "Headphones", 150));
        products.add(new Product(4, "Bluetooth Speaker", 100));
        products.add(new Product(5, "Smartwatch", 250));
        products.add(new Product(6, "Tablet", 600));
        products.add(new Product(7, "Desktop PC", 1200));
        products.add(new Product(8, "Gaming Console", 500));
        products.add(new Product(9, "Monitor", 300));
        products.add(new Product(10, "Keyboard", 70));
        products.add(new Product(11, "Mouse", 50));
        products.add(new Product(12, "Webcam", 90));
        products.add(new Product(13, "External Hard Drive", 100));
        products.add(new Product(14, "Flash Drive", 25));
        products.add(new Product(15, "Printer", 200));
        products.add(new Product(16, "Wireless Charger", 40));
        products.add(new Product(17, "Camera", 700));
        products.add(new Product(18, "Projector", 450));
        products.add(new Product(19, "Drone", 900));
        products.add(new Product(20, "Fitness Tracker", 130));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products);
    }

    @Override
    public Product findById(int id) {
        return products.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Product save(Product product) {
        // If this is a new product (id is 0), generate a new ID
        if (product.getId() == 0) {
            product.setId(idCounter.incrementAndGet());
            products.add(product);
        } else {
            // For updates, find and replace the existing product
            Product existingProduct = findById(product.getId());
            if (existingProduct != null) {
                int index = products.indexOf(existingProduct);
                products.set(index, product);
            } else {
                // If product with that ID doesn't exist, add as new
                products.add(product);
            }
        }
        return product;
    }

    @Override
    public void delete(Product product) {
        products.remove(product);
    }
}