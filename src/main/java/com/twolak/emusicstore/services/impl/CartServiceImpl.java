package com.twolak.emusicstore.services.impl;

import java.util.Optional;

import javax.cache.annotation.CacheKey;
import javax.transaction.Transactional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import com.twolak.emusicstore.model.Cart;
import com.twolak.emusicstore.model.CartItem;
import com.twolak.emusicstore.model.Customer;
import com.twolak.emusicstore.model.Product;
import com.twolak.emusicstore.repositories.CartRepository;
import com.twolak.emusicstore.services.CartService;
import com.twolak.emusicstore.services.ProductService;

@EnableCaching
@Service
public class CartServiceImpl implements CartService {
	
	private final CartRepository cartRepository;
	private final ProductService productService;
	
	public CartServiceImpl(CartRepository cartRepository, ProductService productService) {
		this.cartRepository = cartRepository;
		this.productService = productService;
	}
	
	@Cacheable(cacheNames = "CART_CACHE")
	@Transactional
	@Override
	public Cart getCartById(@CacheKey Long cartId) {
		return this.cartRepository.findById(cartId)
				.orElseThrow(() -> new RuntimeException("Cart not found by id " + cartId));
	}
	
	@CachePut(cacheNames = "CART_CACHE")
	@Transactional
	@Override
	public Cart update(@CacheKey Long cartId, Cart cart) {
		Cart foundCart = this.cartRepository.findById(cartId)
				.orElseThrow(() -> new RuntimeException("Cart not found by id " + cartId));
		foundCart.setCartItems(cart.getCartItems());
		foundCart.setGrandTotal(cart.getGrandTotal());
		
		return this.cartRepository.save(foundCart);
	}
	
	@CacheEvict(cacheNames = "CART_CACHE")
	@Transactional
	@Override
	public void delete(@CacheKey Long cartId) {
		this.cartRepository.deleteById(cartId);
	}

	@CachePut(cacheNames = "CART_CACHE", key = "#result.id")
	@Transactional
	@Override
	public Cart addItem(Cart cart, Long productId) {
		Product product = this.productService.getProductById(productId);
		cart.addCartItem(new CartItem(product));
		return this.cartRepository.save(cart);
	}
	
	@CachePut(cacheNames = "CART_CACHE", key = "#result.id")
	@Transactional
	@Override
	public Cart removeItem(Cart cart, Long productId) {
		Product product = this.productService.getProductById(productId);
		cart.removeCartItem(product);
		return this.cartRepository.save(cart);
	}
	
	@CachePut(cacheNames = "CART_CACHE", key = "#result.id")
	@Transactional
	@Override
	public Cart removeItems(Cart cart) {
		cart.removeCartItems();
		return this.cartRepository.save(cart);
	}

	@CachePut(cacheNames = "CART_CACHE", key = "#result.id")
	@Transactional
	@Override
	public Cart createCustomerCart(Customer savedCustomer) {
		return this.createNewCart(savedCustomer);
	}
	
	@CacheEvict(cacheNames = "CART_CACHE", key = "#cart.id")
	@Transactional
	@Override
	public void processOrder(Cart cart) {
		cart.setActive(false);
		this.cartRepository.save(cart);
		
		this.createNewCart(cart.getCustomer());
	}
	
	@Override
	public Cart validate(Long cartId) {
		Optional<Cart> cart = this.cartRepository.findById(cartId);
		if (cart.isEmpty() || cart.get().getCartItems().size() == 0) {
			throw new RuntimeException("Cart not found by id " + cartId);
		}
		return cart.get();
	}
	
	private Cart createNewCart(Customer customer) {
		Cart cart = Cart.builder().active(true).build();
		customer.addCart(cart);
		return this.cartRepository.save(cart);
	}
}
