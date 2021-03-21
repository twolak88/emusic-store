package com.twolak.emusicstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.twolak.emusicstore.model.Product;
import com.twolak.emusicstore.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public String getProducts(Model model) {
		Iterable<Product> products = this.productService.getAllProducts();
		model.addAttribute("products", products);
		return "productList";
	}
	
	@GetMapping("/{id}")
	public String getProduct(@PathVariable("id") Long id, Model model) {
		Product product = this.productService.getProductById(id);
		model.addAttribute("product", product);
		return "viewProduct";
	}
}
