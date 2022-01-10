package com.nazarov.shop.web;

import com.nazarov.shop.entity.Product;
import com.nazarov.shop.service.ProductServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/products")
@RequiredArgsConstructor

public class ShopController {

    Logger logger = LoggerFactory.getLogger(getClass());

    private final ProductServiceImplementation productServiceImplementation;

    @GetMapping
    public List<Product> findAAll() {
        List<Product> products = productServiceImplementation.findAll();
        logger.info("products size{}", products.size());
        logger.info("products {}", products);

        return products;
    }


    @PostMapping
    public void addProducts(@RequestBody Product product){
        logger.info("add products {}", product);
        productServiceImplementation.addProduct(product);

    }

}
