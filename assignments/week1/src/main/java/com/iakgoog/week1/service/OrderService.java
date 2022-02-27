package com.iakgoog.week1.service;

import com.iakgoog.week1.entity.Order;
import com.iakgoog.week1.exception.OrderNotFoundException;
import com.iakgoog.week1.exception.ProductNotFoundException;
import com.iakgoog.week1.repository.OrderItemRepository;
import com.iakgoog.week1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<Order> listOrder() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Integer id) throws OrderNotFoundException {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(String.valueOf(id)));
        return order;
    }
}
