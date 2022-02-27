package com.iakgoog.week1.repository;

import com.iakgoog.week1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p where lower(p.name) like %?1%")
    List<Product> findByProductName(String chars);
}
