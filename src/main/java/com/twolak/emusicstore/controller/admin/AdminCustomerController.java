package com.twolak.emusicstore.controller.admin;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.twolak.emusicstore.model.Customer;
import com.twolak.emusicstore.services.CustomerService;

@Controller
@RequestMapping("/admin/customers")
public class AdminCustomerController {
	
	private final CustomerService customerService;
	
	public AdminCustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/{customerId}")
	public String customerDetails(@PathVariable("customerId") Long customerId, Model model) {
		Customer customer = this.customerService.getCustomerById(customerId);
		model.addAttribute("customer", customer);
		return "admin/customer/details";
	}
	
	@GetMapping("/edit/{customerId}")
	public String editCustomer(@PathVariable("customerId") Long customerId, Model model) {
		Customer customer = this.customerService.getCustomerById(customerId);
		model.addAttribute("customer", customer);
		return "admin/customer/edit";
	}
	
	@PostMapping("/edit")
	public String updateCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "admin/customer/edit";
		}
		this.customerService.updateCustomer(customer);
		return "redirect:/admin/customers";
	}
}
