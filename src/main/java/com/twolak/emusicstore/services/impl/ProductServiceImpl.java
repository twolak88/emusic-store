package com.twolak.emusicstore.services.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.twolak.emusicstore.model.Product;
import com.twolak.emusicstore.repositories.ProductRepository;
import com.twolak.emusicstore.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Transactional
	@Override
	public Product addProduct(Product product) {
		return this.productRepository.save(product);
	}

	@Override
	public Product getProductById(Long id) {
		return this.productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException(String.format("Product id: %d not found", id)));
	}

	@Override
	public Iterable<Product> getAllProducts() {
		return this.productRepository.findAll();
	}
	
	@Transactional
	@Override
	public void deleteProduct(Long id) {
		this.productRepository.deleteById(id);
	}

	@Override
	public Product getNewProduct() {
		return Product.builder()
				.category("instrument")
				.condition("new")
				.status("active")
				.build();
	}

}
