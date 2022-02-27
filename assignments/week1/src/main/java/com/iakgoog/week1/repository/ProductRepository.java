package com.iakgoog.week1.repository;

import com.iakgoog.week1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
