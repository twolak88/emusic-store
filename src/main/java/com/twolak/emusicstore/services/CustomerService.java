package com.twolak.emusicstore.services;

import com.twolak.emusicstore.model.Customer;

public interface CustomerService {
	Customer getNewCustomer();

	void addCustomer(Customer customer);
	
	Customer getCustomerById(Long id);
	
	Iterable<Customer> getAllCustomers();
}
