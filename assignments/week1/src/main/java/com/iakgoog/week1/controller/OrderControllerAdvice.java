package com.iakgoog.week1.controller;

import com.iakgoog.week1.common.ApiResponse;
import com.iakgoog.week1.exception.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OrderControllerAdvice {

    @ExceptionHandler(OrderNotFoundException.class)
    @ResponseBody
    public ResponseEntity<ApiResponse> orderNotFound(OrderNotFoundException e) {
        return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Order {" + e.getMessage() + "} not found"), HttpStatus.NOT_FOUND);
    } 
}
