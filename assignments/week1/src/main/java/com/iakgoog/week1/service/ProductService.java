package com.iakgoog.week1.service;

import com.iakgoog.week1.entity.Product;
import com.iakgoog.week1.exception.ProductNotFoundException;
import com.iakgoog.week1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> findByProductName(String name) {
        return productRepository.findByProductName(name);
    }

    public Product getProductById(Integer id) throws ProductNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(String.valueOf(id)));
        return product;
    }
}
