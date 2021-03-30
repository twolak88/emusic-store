package com.twolak.emusicstore.model;

import java.util.Optional;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Cart {
	
	@Id
	private String id;
	
	@Builder.Default
	@OneToMany(mappedBy="cart", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<CartItem> cartItems = new HashSet<>();
	
	@Builder.Default
	private double grandTotal = 0;
	
	public void addCartItem(CartItem cartItem) {
		Optional<CartItem> foundItem = this.cartItems.stream()
				.filter(item -> item.getProduct().getId().equals(cartItem.getProduct().getId()))
				.findFirst();
		if (foundItem.isPresent()) {
			CartItem item = foundItem.get();
			item.setQuantity(item.getQuantity() + cartItem.getQuantity());
			item.setTotalPrice(item.getTotalPrice() + cartItem.getTotalPrice());
		} else {
			cartItem.setCart(this);
			this.cartItems.add(cartItem);
		}
		this.grandTotal += cartItem.getTotalPrice();
	}
	
	public void removeCartItem(Product product) {
		Optional<CartItem> foundItem = this.cartItems.stream()
				.filter(item -> item.getProduct().getId().equals(product.getId()))
				.findFirst();
		if (foundItem.isPresent()) {
			if (this.cartItems.remove(foundItem.get())) {
				this.grandTotal -= foundItem.get().getTotalPrice();
			}
		}
	}
	
	public void removeCartItems() {
		cartItems.clear();
		this.grandTotal = 0;
	}
}
