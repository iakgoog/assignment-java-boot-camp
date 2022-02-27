package com.iakgoog.week1.controller;

import com.iakgoog.week1.common.ApiResponse;
import com.iakgoog.week1.entity.Order;
import com.iakgoog.week1.exception.OrderNotFoundException;
import com.iakgoog.week1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        return new ResponseEntity<List<Order>>(orderService.listOrder(), HttpStatus.OK);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable String id) throws OrderNotFoundException {
        int parsedId = Integer.parseInt(id);
        Order order = orderService.getOrderById(parsedId);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @PostMapping("/orders")
    public ResponseEntity<ApiResponse> placeOrder() {
        orderService.placeOrder();
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Order has been placed"), HttpStatus.CREATED);
    }

    @PostMapping("/orders/{id}/pay")
    public ResponseEntity<ApiResponse> performPayment(@PathVariable String id) {
        int parsedId = Integer.parseInt(id);
        orderService.performPayment(parsedId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Order has been paid successfully"), HttpStatus.OK);
    }
}
