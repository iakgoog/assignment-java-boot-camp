package com.iakgoog.week1.controller;

import com.iakgoog.week1.common.ApiResponse;
import com.iakgoog.week1.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseBody
    public ResponseEntity<ApiResponse> productNotFound(ProductNotFoundException e) {
        return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Product {" + e.getMessage() + "} not found"), HttpStatus.NOT_FOUND);
    } 
}
