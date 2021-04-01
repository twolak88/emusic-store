package com.twolak.emusicstore.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "carts")
public class Cart implements Serializable {
	
	private static final long serialVersionUID = 921872818895631695L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@Builder.Default
	@OneToMany(mappedBy="cart", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<CartItem> cartItems = new HashSet<>();
	
	@Builder.Default
	private double grandTotal = 0;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	@JsonBackReference
	private Customer customer;
	
	@OneToOne(mappedBy = "cart")
	@JsonManagedReference
	private Order order;
	
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
