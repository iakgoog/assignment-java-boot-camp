package com.iakgoog.week1.controller;

import com.iakgoog.week1.entity.Product;
import com.iakgoog.week1.exception.ProductNotFoundException;
import com.iakgoog.week1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProductWithOptionalParam(@RequestParam Optional<String> query) {
        if (query.isPresent()) {
            return new ResponseEntity<List<Product>>(productService.findByProductName(query.get()), HttpStatus.OK);
        }
        return new ResponseEntity<List<Product>>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) throws ProductNotFoundException {
        int parsedId = Integer.parseInt(id);
        Product product = productService.getProductById(parsedId);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
}
