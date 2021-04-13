package com.twolak.emusicstore.services.impl;

import javax.cache.annotation.CacheKey;
import javax.transaction.Transactional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.twolak.emusicstore.model.Product;
import com.twolak.emusicstore.repositories.ProductRepository;
import com.twolak.emusicstore.services.ImageService;
import com.twolak.emusicstore.services.ProductService;

@EnableCaching
@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	private final ImageService imageService;
	
	public ProductServiceImpl(ProductRepository productRepository, ImageService imageService) {
		this.productRepository = productRepository;
		this.imageService = imageService;
	}
	
	@CacheEvict(cacheNames = "PRODUCTS_CACHE")
	@CachePut(cacheNames = "PRODUCT_CACHE", key = "#result.id")
	@Transactional
	@Override
	public Product addProduct(Product product, String rootPath) {
		MultipartFile productImage = product.getImage();
		String imageUrl = imageService.saveProductImage(productImage, rootPath, null);
		product.setImageUrl(imageUrl);
		Product savedProduct = this.productRepository.save(product);
		return savedProduct;
	}
	
	@CacheEvict(cacheNames = "PRODUCTS_CACHE")
	@CachePut(cacheNames = "PRODUCT_CACHE", key = "#result.id")
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

	@Cacheable(cacheNames = "PRODUCT_CACHE")
	@Override
	public Product getProductById(@CacheKey Long id) {
		return this.productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException(String.format("Product id: %d not found", id)));
	}

	@Cacheable(cacheNames = "PRODUCTS_CACHE")
	@Override
	public Iterable<Product> getAllProducts() {
		return this.productRepository.findAll();
	}
	
	@CacheEvict(cacheNames = {"PRODUCT_CACHE", "PRODUCTS_CACHE"})
	@Transactional
	@Override
	public void deleteProduct(@CacheKey Long id, String rootPath) {
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
