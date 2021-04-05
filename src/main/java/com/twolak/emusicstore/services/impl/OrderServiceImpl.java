package com.twolak.emusicstore.services.impl;

import org.springframework.stereotype.Service;

import com.twolak.emusicstore.model.Cart;
import com.twolak.emusicstore.model.CartItem;
import com.twolak.emusicstore.model.Order;
import com.twolak.emusicstore.repositories.CartRepository;
import com.twolak.emusicstore.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	private final CartRepository cartRepository;
	
	public OrderServiceImpl(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}

	@Override
	public void addOrder(Cart cart) {
		Order order = Order.builder()
			.cart(cart)
			.billingAddress(cart.getCustomer().getBillingAddress())
			.shippingAddress(cart.getCustomer().getShippingAddress())
			.build();
		cart.setOrder(order);
		cart.getCustomer().addOrder(order);
		this.cartRepository.save(cart);
	}

	@Override
	public double getCustomerOrderGrandTotal(Cart cart) {
		return cart.getCartItems().stream().mapToDouble(CartItem::getTotalPrice).sum();
	}
}
