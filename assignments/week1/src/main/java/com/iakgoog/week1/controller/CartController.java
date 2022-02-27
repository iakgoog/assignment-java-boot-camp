package com.iakgoog.week1.controller;

import com.iakgoog.week1.entity.Cart;
import com.iakgoog.week1.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;


    @GetMapping("/carts")
    public ResponseEntity<List<Cart>> getCartItems() {
        return new ResponseEntity<List<Cart>>(cartService.getAllCarts(), HttpStatus.OK);
    }

}
