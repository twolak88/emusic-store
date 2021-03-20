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
		
		Product product2 = Product.builder()
				.name("Piano")
				.category("Instrument")
				.description("This is a piano")
				.price(1200)
				.condition("new")
				.status("Active")
				.unitInStock(5)
				.manufacturer("DMS")
				.build();
		
		Product product3 = Product.builder()
				.name("Record")
				.category("Record")
				.description("This is a awesome mix")
				.price(300)
				.condition("new")
				.status("Active")
				.unitInStock(7)
				.manufacturer("EMI")
				.build();
		
		Product product4 = Product.builder()
				.name("Speaker")
				.category("Accessory")
				.description("This is a awesome speaker")
				.price(299)
				.condition("new")
				.status("Active")
				.unitInStock(7)
				.manufacturer("Polk")
				.build();
		
		productList = new ArrayList<>();
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		productList.add(product4);
		return productList;
	}

}
