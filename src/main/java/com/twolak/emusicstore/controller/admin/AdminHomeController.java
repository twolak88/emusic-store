package com.twolak.emusicstore.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.twolak.emusicstore.model.Customer;
import com.twolak.emusicstore.model.Product;
import com.twolak.emusicstore.services.CustomerService;
import com.twolak.emusicstore.services.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {
	
	private final ProductService productService;
	private final CustomerService customerService;
	
	public AdminHomeController(ProductService productService, CustomerService customerService) {
		this.productService = productService;
		this.customerService = customerService;
	}

	@GetMapping
	public String adminPage() {
		return "admin/admin";
	}
	
	@GetMapping("/products")
	public String productInventory(Model model){
		Iterable<Product> products = this.productService.getAllProducts();
		model.addAttribute("products", products);
		return "admin/product/products";
	}
	
	@GetMapping("/customers")
	public String customerManagement(Model model) {
		Iterable<Customer> customers = this.customerService.getAllCustomers();
		model.addAttribute("customers", customers);
		return "admin/customerManagement";
	}
}
