package com.twolak.emusicstore.services.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.twolak.emusicstore.model.Product;
import com.twolak.emusicstore.repositories.ProductRepository;
import com.twolak.emusicstore.services.ImageService;
import com.twolak.emusicstore.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	private final ImageService imageService;
	
	public ProductServiceImpl(ProductRepository productRepository, ImageService imageService) {
		this.productRepository = productRepository;
		this.imageService = imageService;
	}
	
	@Transactional
	@Override
	public Product addProduct(Product product, String rootPath) {
		MultipartFile productImage = product.getImage();
		String imageUrl = imageService.saveProductImage(productImage, rootPath, null);
		product.setImageUrl(imageUrl);
		Product savedProduct = this.productRepository.save(product);
		return savedProduct;
	}
	
	@Transactional
	@Override
	public Product updateProduct(Product product, String rootPath) {
		MultipartFile productImage = product.getImage();
		String imageUrl = product.getImageUrl();
		if (productImage != null && !productImage.isEmpty()) {
			imageUrl = imageService.saveProductImage(productImage, rootPath, imageUrl);
		}
		product.setImageUrl(imageUrl);
		Product savedProduct = this.productRepository.save(product);
		return savedProduct;
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
	public void deleteProduct(Long id, String rootPath) {
		Product product = this.getProductById(id);
		this.imageService.deleteProductImage(rootPath, product.getImageUrl());
		
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
