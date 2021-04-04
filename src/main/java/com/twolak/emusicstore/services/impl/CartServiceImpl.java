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
	public Cart getCartById(Long cartId) {
		return this.cartRepository.findById(cartId)
				.orElseThrow(() -> new RuntimeException("Cart not found by id " + cartId));
	}

	@Transactional
	@Override
	public void update(Long cartId, Cart cart) {
		Cart foundCart = this.cartRepository.findById(cartId)
				.orElseThrow(() -> new RuntimeException("Cart not found by id " + cartId));
		foundCart.setCartItems(cart.getCartItems());
		foundCart.setGrandTotal(cart.getGrandTotal());
		
		this.cartRepository.save(foundCart);
	}

	@Transactional
	@Override
	public void delete(Long cartId) {
		this.cartRepository.deleteById(cartId);
	}

	@Transactional
	@Override
	public Cart addItem(Cart cart, Long productId) {
		Product product = this.productService.getProductById(productId);
		cart.addCartItem(new CartItem(product));
		return this.cartRepository.save(cart);
	}
	
	@Transactional
	@Override
	public void removeItem(Cart cart, Long productId) {
		Product product = this.productService.getProductById(productId);
		cart.removeCartItem(product);
		this.cartRepository.save(cart);
	}
	
	@Transactional
	@Override
	public void removeItems(Cart cart) {
		cart.removeCartItems();
		this.cartRepository.save(cart);
	}

	@Override
	public void createCustomerCart(Customer savedCustomer) {
		Cart cart = Cart.builder().active(true).build();
		savedCustomer.addCart(cart);
		this.cartRepository.save(cart);
	}
}
