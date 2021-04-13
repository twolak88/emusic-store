package com.twolak.emusicstore.services;

import com.twolak.emusicstore.model.Cart;
import com.twolak.emusicstore.model.Customer;

public interface CartService {

	Cart getCartById(Long cartId);

	Cart update(Long cartId, Cart cart);

	void delete(Long cartId);

	Cart addItem(Cart cart, Long productId);

	Cart removeItem(Cart cart, Long productId);

	Cart removeItems(Cart cart);

	Cart createCustomerCart(Customer savedCustomer);
	
	void processOrder(Cart cart);
	
	Cart validate(Long cartId);
}
