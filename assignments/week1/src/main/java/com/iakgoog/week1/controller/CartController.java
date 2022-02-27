package com.iakgoog.week1.controller;

import com.iakgoog.week1.common.ApiResponse;
import com.iakgoog.week1.dto.AddToCartDto;
import com.iakgoog.week1.entity.Cart;
import com.iakgoog.week1.entity.Product;
import com.iakgoog.week1.exception.ProductNotFoundException;
import com.iakgoog.week1.service.CartService;
import com.iakgoog.week1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @GetMapping("/carts")
    public ResponseEntity<List<Cart>> getCartItems() {
        return new ResponseEntity<List<Cart>>(cartService.getAllCarts(), HttpStatus.OK);
    }

    @PostMapping("/carts")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto) throws ProductNotFoundException {
        Product product = productService.getProductById(addToCartDto.getProductId());
        System.out.println("product to add = "+  product.getName());
        cartService.addToCart(addToCartDto, product);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);
    }

}
