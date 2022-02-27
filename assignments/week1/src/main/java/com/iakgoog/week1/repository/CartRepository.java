package com.iakgoog.week1.repository;

import com.iakgoog.week1.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
