package com.twolak.emusicstore.services.impl;

import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.twolak.emusicstore.model.Authorities;
import com.twolak.emusicstore.model.BillingAddress;
import com.twolak.emusicstore.model.Customer;
import com.twolak.emusicstore.model.ShippingAddress;
import com.twolak.emusicstore.model.User;
import com.twolak.emusicstore.repositories.AuthoritiesRepository;
import com.twolak.emusicstore.repositories.CustomerRepository;
import com.twolak.emusicstore.repositories.UserRepository;
import com.twolak.emusicstore.services.CartService;
import com.twolak.emusicstore.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	private final CustomerRepository customerRepository;
	private final UserRepository userRepository;
	private final AuthoritiesRepository authoritiesRepository;
	private final CartService cartService;
	
	public CustomerServiceImpl(CustomerRepository customerRepository, UserRepository userRepository, AuthoritiesRepository authoritiesRepository, CartService cartService) {
		this.customerRepository = customerRepository;
		this.userRepository = userRepository;
		this.authoritiesRepository = authoritiesRepository;
		this.cartService = cartService;
	}

	@Override
	public Customer getNewCustomer() {
		BillingAddress billingAddress = new BillingAddress();
		ShippingAddress shippingAddress = new ShippingAddress();
		Customer customer = Customer.builder()
				.enabled(true)
				.billingAddress(billingAddress)
				.shippingAddress(shippingAddress)
				.build();
		billingAddress.setCustomer(customer);
		shippingAddress.setCustomer(customer);
		return customer;
	}

	@Transactional
	@Override
	public void addCustomer(Customer customer) {
		customer.setPassword(new BCryptPasswordEncoder().encode(customer.getPassword()));
		Customer savedCustomer = this.customerRepository.save(customer);
		User user = User.builder().customerId(savedCustomer.getId())
				.username(savedCustomer.getUsername())
				.password(customer.getPassword())
				.enabled(customer.isEnabled())
				.build();
		User savedUser = this.userRepository.save(user);
		Authorities authorities = Authorities.builder()
				.username(savedUser.getUsername())
				.authority("USER_ROLE")
				.build();
		this.authoritiesRepository.save(authorities);
		this.cartService.createCustomerCart(savedCustomer);
		this.customerRepository.save(savedCustomer);		
	}

	@Override
	public Customer getCustomerById(Long id) {
		return this.customerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Customer doesn't exist for id: " + id));
	}

	@Override
	public Iterable<Customer> getAllCustomers() {
		return this.customerRepository.findAll();
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		return this.customerRepository.findByUsername(username);
	}

	@Override
	public String getActiveCartForCustomer(Customer customer) {
		return customer.getCarts()
				.stream()
				.filter(cart -> cart.isActive())
				.findFirst()
				.orElseThrow(() -> new RuntimeException("There is no active cart for customer " + customer.getUsername())).getId();
	}
}
