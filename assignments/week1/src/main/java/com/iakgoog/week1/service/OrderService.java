package com.iakgoog.week1.service;

import com.iakgoog.week1.dto.CartDto;
import com.iakgoog.week1.dto.CartItemDto;
import com.iakgoog.week1.entity.Order;
import com.iakgoog.week1.entity.OrderItem;
import com.iakgoog.week1.entity.PaymentStatus;
import com.iakgoog.week1.exception.OrderNotFoundException;
import com.iakgoog.week1.exception.ProductNotFoundException;
import com.iakgoog.week1.repository.OrderItemRepository;
import com.iakgoog.week1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
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

    public void placeOrder() {
        CartDto cartDto = cartService.listCartItems();

        List<CartItemDto> cartItemDtoList = cartDto.getCartItems();

        Order newOrder = new Order();
        newOrder.setCreatedDate(new Date());
        newOrder.setTotalPrice(cartDto.getTotalCost());
        newOrder.setPaymentStatus(PaymentStatus.READY_TO_PAY.label);
        orderRepository.save(newOrder);

        for (CartItemDto cartItemDto : cartItemDtoList) {
            OrderItem orderItem = new OrderItem();
            orderItem.setPrice(cartItemDto.getProduct().getPrice());
            orderItem.setProduct(cartItemDto.getProduct());
            orderItem.setQuantity(cartItemDto.getQuantity());
            orderItem.setOrder(newOrder);
            orderItemRepository.save(orderItem);
        }

        cartService.deleteCartItems();
    }

    public void performPayment(Integer id) throws OrderNotFoundException {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(String.valueOf(id)));
        // perform interaction with payment gateway
        order.setPaymentStatus(PaymentStatus.PAID.label);
    }
}
