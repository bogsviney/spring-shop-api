package com.nazarov.shop.service;

import com.nazarov.shop.entity.Product;
import com.nazarov.shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImplementation implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }
}
