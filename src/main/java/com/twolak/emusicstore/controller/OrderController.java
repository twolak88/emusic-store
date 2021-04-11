package com.twolak.emusicstore.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.twolak.emusicstore.model.Cart;
import com.twolak.emusicstore.model.Order;
import com.twolak.emusicstore.services.CartService;
import com.twolak.emusicstore.services.CustomerService;
import com.twolak.emusicstore.services.OrderService;
import com.twolak.emusicstore.services.security.UserDetailsImpl;

@Controller
public class OrderController {
	
	private final OrderService orderService;
	private final CartService cartService;
	private final CustomerService customerService;

	public OrderController(OrderService orderService, CartService cartService, CustomerService customerService) {
		this.orderService = orderService;
		this.cartService = cartService;
		this.customerService = customerService;
	}

	@GetMapping("/order/{cartId}")
	public String createOrder(@PathVariable("cartId") Long cartId) {
		Cart cart = this.cartService.getCartById(cartId);
		this.orderService.addOrder(cart);
		return "redirect:/checkout?cartId=" + cartId;
	}
	
	@GetMapping("/customer/orders")
	public String orders(@AuthenticationPrincipal UserDetailsImpl activeUser, Model model) {
		Iterable<Order> orders = this.customerService.getCustomerOrders(activeUser.getUsername());
		model.addAttribute("orders", orders);
		return "customer/orders";
	}
	
	@GetMapping("/customer/orders/{orderId}")
	public String viewOrder(@PathVariable("orderId") Long orderId, Model model) {
		Order order = this.orderService.findOrder(orderId);
		model.addAttribute("order", order);
		return "customer/orderDetails";
	}
}
