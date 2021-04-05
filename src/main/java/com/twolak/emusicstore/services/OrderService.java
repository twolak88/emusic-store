package com.twolak.emusicstore.services;

import com.twolak.emusicstore.model.Cart;

public interface OrderService {

	void addOrder(Cart cart);

	double getCustomerOrderGrandTotal(Cart cart);
}
