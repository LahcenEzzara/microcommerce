package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAll();

    Product findById(int id);

    Product save(Product product);
}
