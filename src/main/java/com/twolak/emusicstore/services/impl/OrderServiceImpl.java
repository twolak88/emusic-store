package com.twolak.emusicstore.services.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.twolak.emusicstore.model.Cart;
import com.twolak.emusicstore.model.CartItem;
import com.twolak.emusicstore.model.Order;
import com.twolak.emusicstore.model.OrderStatus;
import com.twolak.emusicstore.repositories.CartRepository;
import com.twolak.emusicstore.repositories.OrderRepository;
import com.twolak.emusicstore.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	private final CartRepository cartRepository;
	private final OrderRepository orderRepository;
	
	public OrderServiceImpl(CartRepository cartRepository, OrderRepository orderRepository) {
		this.cartRepository = cartRepository;
		this.orderRepository = orderRepository;
	}

	@Transactional
	@Override
	public void addOrder(Cart cart) {
		Order order = Order.builder()
			.cart(cart)
			.billingAddress(cart.getCustomer().getBillingAddress())
			.shippingAddress(cart.getCustomer().getShippingAddress())
			.status(OrderStatus.ORDERED)
			.build();
		cart.setOrder(order);
		cart.getCustomer().addOrder(order);
		this.cartRepository.save(cart);
	}

	@Override
	public double getCustomerOrderGrandTotal(Cart cart) {
		return cart.getCartItems().stream().mapToDouble(CartItem::getTotalPrice).sum();
	}
	
	@Transactional
	@Override
	public void cancelOrder(Cart cart) {
		Order order = cart.getOrder();
		cart.setOrder(null);
		order.setCart(null);
		order.getCustomer().getOrders().remove(order);
		order.setCustomer(null);
		order.setBillingAddress(null);
		order.setShippingAddress(null);
		this.orderRepository.delete(order);
		this.cartRepository.save(cart);
	}

	@Override
	public Order findOrder(Long orderId) {
		return this.orderRepository.findById(orderId)
				.orElseThrow(() -> new RuntimeException("Order not found for id: " + orderId));
	}
}
