package com.twolak.emusicstore.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.twolak.emusicstore.model.Product;
import com.twolak.emusicstore.services.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {
	
	private final ProductService productService;
	
	public AdminHomeController(ProductService productService) {
		this.productService = productService;
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
	
	@GetMapping("customer")
	public String customerManagement(Model model) {
		//TODO: customer service
		return "admin/customerManagement";
	}
}
