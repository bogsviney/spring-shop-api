package com.nazarov.shop.repository;

import java.util.List;

import com.nazarov.shop.entity.Product;


public interface ProductRepository {
    List<Product> findAll();

    void addProduct(Product product);
}
