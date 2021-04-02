package com.twolak.emusicstore.services;

import com.twolak.emusicstore.model.Cart;
import com.twolak.emusicstore.model.Customer;

public interface CartService {

	Cart readCart(String cartId);

	void update(String cartId, Cart cart);

	void delete(String cartId);

	Cart addItem(String sessionId, Long productId);

	void removeItem(String sessionId, Long productId);

	void removeItems(String sessionId);

	void createCustomerCart(Customer savedCustomer);

}
