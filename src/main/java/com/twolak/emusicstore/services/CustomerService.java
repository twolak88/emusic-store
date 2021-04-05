package com.twolak.emusicstore.services;

import org.springframework.validation.BindingResult;

import com.twolak.emusicstore.model.Cart;
import com.twolak.emusicstore.model.Customer;

public interface CustomerService {
	Customer getNewCustomer();

	void addCustomer(Customer customer);
	
	Customer getCustomerById(Long id);
	
	Iterable<Customer> getAllCustomers();

//	Customer getCustomerByUsername(String username);

	Cart getActiveCartForCustomer(String username);

	boolean validateCustomer(Customer customer, BindingResult bindingResult);
}
