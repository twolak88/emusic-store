package com.twolak.emusicstore.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.twolak.emusicstore.dao.ProductDao;
import com.twolak.emusicstore.model.Product;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	private final ProductDao productDao;
	
	public ProductController(ProductDao productDao) {
		this.productDao = productDao;
	}

	@GetMapping("/list")
	public String getProducts(Model model) {
		List<Product> products = this.productDao.getProductList();
		model.addAttribute("product", products.get(0));
		return "productList";
	}
}
