package com.twolak.emusicstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.twolak.emusicstore.model.Product;
import com.twolak.emusicstore.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/all")
	public String getProducts(Model model) {
		Iterable<Product> products = this.productService.getAllProducts();
		model.addAttribute("products", products);
		return "product/productList";
	}
	
	@GetMapping("/{id}")
	public String viewProduct(@PathVariable("id") Long id, Model model) {
		Product product = this.productService.getProductById(id);
		model.addAttribute("product", product);
		return "product/viewProduct";
	}
	
	@GetMapping
	public String getProductsByCategory(@RequestParam("searchCondition") String searchCondition, Model model) {
		Iterable<Product> products = this.productService.getAllProducts();
		model.addAttribute("products", products);
		model.addAttribute("searchCondition", searchCondition);
		return "product/productList";
	}
}
