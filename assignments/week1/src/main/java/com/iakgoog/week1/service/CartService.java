package com.iakgoog.week1.service;

import com.iakgoog.week1.dto.AddToCartDto;
import com.iakgoog.week1.entity.Cart;
import com.iakgoog.week1.entity.Product;
import com.iakgoog.week1.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public void addToCart(AddToCartDto addToCartDto, Product product) {
        Cart cart = new Cart(product, addToCartDto.getQuantity());
        cartRepository.save(cart);
    }

}
