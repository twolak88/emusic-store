package com.twolak.emusicstore.controller;

import javax.servlet.http.HttpServletRequest;

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
	public String saveProduct(@ModelAttribute("product") Product product, HttpServletRequest request) {
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		this.productService.addProduct(product, rootDirectory);
		
		return "redirect:/admin/productInventory";
	}
	
	@GetMapping("/productInventory/delete/{id}")
	public String deleteProduct(@PathVariable("id") Long id, HttpServletRequest request) {
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		this.productService.deleteProduct(id, rootDirectory);
		return "redirect:/admin/productInventory";
	}
	
	@GetMapping("/productInventory/edit/{id}")
	public String editProduct(@PathVariable("id") Long id, Model model) {
		Product product = this.productService.getProductById(id);
		model.addAttribute("product", product);
		return "admin/editProduct";
	}
	
	@PostMapping("/productInventory/edit")
	public String updateProduct(@ModelAttribute("product") Product product, Model model, HttpServletRequest request) {
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		this.productService.updateProduct(product, rootDirectory);
		
		return "redirect:/admin/productInventory";
	}
}
