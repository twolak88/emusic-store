package com.twolak.emusicstore.services;

import com.twolak.emusicstore.model.Product;

public interface ProductService {
	
	Product addProduct(Product product);
	
	Product getProductById(Long id);
	
	Iterable<Product> getAllProducts();
	
	void deleteProduct(Long id);
	
	Product getNewProduct();
}
