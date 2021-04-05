package com.twolak.emusicstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.twolak.emusicstore.model.Cart;
import com.twolak.emusicstore.services.CartService;
import com.twolak.emusicstore.services.OrderService;

@Controller
public class OrderController {
	
	private final OrderService orderService;
	private final CartService cartService;

	public OrderController(OrderService orderService, CartService cartService) {
		this.orderService = orderService;
		this.cartService = cartService;
	}

	@GetMapping("/order/{cartId}")
	public String createOrder(@PathVariable("cartId") Long cartId) {
		Cart cart = this.cartService.getCartById(cartId);
		this.orderService.addOrder(cart);
		return "redirect:/checkout?cartId=" + cartId;
	}
}
