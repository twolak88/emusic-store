package com.twolak.emusicstore.services;

import org.springframework.validation.BindingResult;

import com.twolak.emusicstore.model.Cart;
import com.twolak.emusicstore.model.Customer;
import com.twolak.emusicstore.model.Order;

public interface CustomerService {
	Customer getNewCustomer();

	void addCustomer(Customer customer);
	
	void updateCustomer(Customer customer);
	
	Customer getCustomerById(Long id);
	
	Iterable<Customer> getAllCustomers();

//	Customer getCustomerByUsername(String username);

	Cart getActiveCartForCustomer(String username);

	boolean validateCustomer(Customer customer, BindingResult bindingResult);

	void enableCustomer(Long customerId);

	void disableCustomer(Long customerId);

	void deleteCustomer(Long customerId);

	Iterable<Order> getCustomerOrders(String username);
}
