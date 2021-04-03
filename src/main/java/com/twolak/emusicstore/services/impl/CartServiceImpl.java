package com.twolak.emusicstore.services.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.twolak.emusicstore.model.Cart;
import com.twolak.emusicstore.model.CartItem;
import com.twolak.emusicstore.model.Customer;
import com.twolak.emusicstore.model.Product;
import com.twolak.emusicstore.repositories.CartRepository;
import com.twolak.emusicstore.services.CartService;
import com.twolak.emusicstore.services.ProductService;

@Service
public class CartServiceImpl implements CartService {
	
	private final CartRepository cartRepository;
	private final ProductService productService;
	
	public CartServiceImpl(CartRepository cartRepository, ProductService productService) {
		this.cartRepository = cartRepository;
		this.productService = productService;
	}
	
	@Transactional
	@Override
	public Cart readCart(String cartId) {
		return this.cartRepository.findById(cartId)
				.orElseThrow(() -> new RuntimeException("Cart not found by id " + cartId));
	}

	@Transactional
	@Override
	public void update(String cartId, Cart cart) {
		Cart foundCart = this.cartRepository.findById(cartId)
				.orElseThrow(() -> new RuntimeException("Cart not found by id " + cartId));
		foundCart.setCartItems(cart.getCartItems());
		foundCart.setGrandTotal(cart.getGrandTotal());
		
		this.cartRepository.save(foundCart);
	}

	@Transactional
	@Override
	public void delete(String cartId) {
		this.cartRepository.deleteById(cartId);
	}

	@Transactional
	@Override
	public Cart addItem(String sessionId, Long productId) {
		Cart cart = this.cartRepository.findById(sessionId).orElse(null);
		
		Product product = this.productService.getProductById(productId);
		
		if (cart == null) {
			cart = this.create(sessionId, product);
		} else {
			cart.addCartItem(new CartItem(product));
		}
		return this.cartRepository.save(cart);
	}
	
	@Transactional
	@Override
	public void removeItem(String sessionId, Long productId) {
		Cart cart = this.cartRepository.findById(sessionId).orElse(null);
		if (cart == null) {
			cart = Cart.builder().id(sessionId).build();
		}
		Product product = this.productService.getProductById(productId);
		cart.removeCartItem(product);
		this.cartRepository.save(cart);
	}
	
	@Transactional
	@Override
	public void removeItems(String sessionId) {
		Cart cart = this.cartRepository.findById(sessionId).orElse(null);
		if (cart == null) {
			cart = Cart.builder().id(sessionId).build();
		}
		cart.removeCartItems();
		this.cartRepository.save(cart);
	}

	private Cart create(String sessionId, Product product) {
		Cart cart = Cart.builder().id(sessionId).build();
		cart.addCartItem(new CartItem(product));
		return cart;
	}

	@Override
	public void createCustomerCart(Customer savedCustomer) {
		Cart cart = Cart.builder().active(true).build();
		savedCustomer.addCart(cart);
		this.cartRepository.save(cart);
	}
}
