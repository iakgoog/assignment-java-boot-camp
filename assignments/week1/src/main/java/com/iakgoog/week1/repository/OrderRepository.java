package com.iakgoog.week1.repository;

import com.iakgoog.week1.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
