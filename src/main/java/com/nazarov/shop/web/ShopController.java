package com.nazarov.shop.web;

import com.nazarov.shop.entity.Product;
import com.nazarov.shop.service.ProductServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "/products")
@RequiredArgsConstructor

public class ShopController {

    Logger logger = LoggerFactory.getLogger(getClass());

    private final ProductServiceImplementation productServiceImplementation;

    @GetMapping
    public List <Product> findAAll() {
        List<Product> products = productServiceImplementation.findAll();
        logger.info("products size{}", products.size());
        logger.debug("products {}", products); // почему не вижу в логе?((

        return products;
    }

}
