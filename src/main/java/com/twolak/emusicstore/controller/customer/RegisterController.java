package com.twolak.emusicstore.controller.customer;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.twolak.emusicstore.model.Customer;
import com.twolak.emusicstore.services.CustomerService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	private final CustomerService customerService;
	
	public RegisterController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping
	public String registerCustomer(Model model) {
		Customer customer = this.customerService.getNewCustomer();
		model.addAttribute("customer", customer);
		return "customer/register";
	}
	
	@PostMapping
	public String registerCustomerPost(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors() || !this.customerService.validateCustomer(customer, bindingResult)) {
			return "customer/register";
		}
		this.customerService.addCustomer(customer);
		return "customer/registerSuccess";
	}
	
	
}
