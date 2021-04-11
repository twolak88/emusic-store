package com.twolak.emusicstore.services;

import com.twolak.emusicstore.model.Cart;
import com.twolak.emusicstore.model.Order;

public interface OrderService {

	void addOrder(Cart cart);

	double getCustomerOrderGrandTotal(Cart cart);
	
	void cancelOrder(Cart cart);

	Order findOrder(Long orderId);
}
