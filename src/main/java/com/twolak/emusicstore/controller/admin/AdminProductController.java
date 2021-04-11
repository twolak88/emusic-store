package com.twolak.emusicstore.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.twolak.emusicstore.model.Product;
import com.twolak.emusicstore.services.ProductService;
import com.twolak.emusicstore.services.security.UserDetailsImpl;

@Controller
@RequestMapping("/admin")
public class AdminProductController {
	
	private final ProductService productService;
	
	public AdminProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/products/add")
	public String addProduct(Model model) {
		model.addAttribute("product", this.productService.getNewProduct());
		return "admin/product/add";
	}
	
	@PostMapping("/products/add")
	public String saveProduct(@Valid @ModelAttribute("product") Product product, @AuthenticationPrincipal UserDetailsImpl activeUserDetails, BindingResult bindingResult, HttpServletRequest request) {
		
		if (bindingResult.hasErrors()) {
			return "admin/product/add";
		}
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		product.setUser(activeUserDetails.getAuthenticatedUser());
		this.productService.addProduct(product, rootDirectory);
		
		return "redirect:/admin/products";
	}
	
	@GetMapping("/products/delete/{id}")
	public String deleteProduct(@PathVariable("id") Long id, HttpServletRequest request) {
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		this.productService.deleteProduct(id, rootDirectory);
		return "redirect:/admin/products";
	}
	
	@GetMapping("/products/edit/{id}")
	public String editProduct(@PathVariable("id") Long id, Model model) {
		Product product = this.productService.getProductById(id);
		model.addAttribute("product", product);
		return "admin/product/edit";
	}
	
	@PostMapping("/products/edit")
	public String updateProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model, HttpServletRequest request) {
		
		if (bindingResult.hasErrors()) {
			return "admin/product/edit";
		}
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		this.productService.updateProduct(product, rootDirectory);
		
		return "redirect:/admin/products";
	}
}
