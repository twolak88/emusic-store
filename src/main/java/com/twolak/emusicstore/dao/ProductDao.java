package com.twolak.emusicstore.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.twolak.emusicstore.model.Product;

@Component
public class ProductDao {
	private List<Product> productList;
	
	public List<Product> getProductList() {
		Product product1 = Product.builder()
				.name("Guitar1")
				.category("Instrument")
				.description("This is a guitar")
				.price(1000)
				.condition("new")
				.status("Active")
				.unitInStock(10)
				.manufacturer("Fender")
				.build();
		
		productList = new ArrayList<>();
		productList.add(product1);
		return productList;
	}

}
