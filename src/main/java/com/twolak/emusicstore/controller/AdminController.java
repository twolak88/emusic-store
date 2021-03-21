package com.twolak.emusicstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.twolak.emusicstore.model.Product;
import com.twolak.emusicstore.services.ProductService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	private final ProductService productService;
	
	public AdminController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public String adminPage() {
		return "admin/admin";
	}
	
	@GetMapping("/productInventory")
	public String productInventory(Model model){
		Iterable<Product> products = this.productService.getAllProducts();
		model.addAttribute("products", products);
		return "admin/productInventory";
	}
	
	@GetMapping("/productInventory/addProduct")
	public String addProduct(Model model) {
		model.addAttribute("product", this.productService.getNewProduct());
		return "admin/addProduct";
	}
	
	@PostMapping("/productInventory/addProduct")
	public String saveProduct(@ModelAttribute("product") Product product) {
		
		this.productService.addProduct(product);
		return "redirect:/admin/productInventory";
	}
	
	@GetMapping("/productInventory/delete/{id}")
	public String deleteProduct(@PathVariable("id") Long id) {
		this.productService.deleteProduct(id);
		return "redirect:/admin/productInventory";
	}
}
