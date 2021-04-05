package com.twolak.emusicstore.services;

import com.twolak.emusicstore.model.Cart;
import com.twolak.emusicstore.model.Customer;

public interface CartService {

	Cart getCartById(Long cartId);

	void update(Long cartId, Cart cart);

	void delete(Long cartId);

	Cart addItem(Cart cart, Long productId);

	void removeItem(Cart cart, Long productId);

	void removeItems(Cart cart);

	void createCustomerCart(Customer savedCustomer);
	
	void createNextCustomerCart(Cart cart);
	
	Cart validate(Long cartId);
}
