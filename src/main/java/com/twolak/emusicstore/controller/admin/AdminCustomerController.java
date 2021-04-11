package com.twolak.emusicstore.controller.admin;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.twolak.emusicstore.services.CustomerService;

@RestController
@RequestMapping("/admin/rest/customer")
public class AdminCustomerController {
	
	private final CustomerService customerService;

	public AdminCustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PutMapping("/enable/{customerId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void enableCustomer(@PathVariable("customerId") Long customerId) {
		this.customerService.enableCustomer(customerId);
	}
	
	@PutMapping("/disable/{customerId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void disableCustomer(@PathVariable("customerId") Long customerId) {
		this.customerService.disableCustomer(customerId);
	}
}
