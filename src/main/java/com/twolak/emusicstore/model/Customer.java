package com.twolak.emusicstore.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
@Table(name = "customers")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = -4928529125136265639L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "The customer name should not be empty.")
	@Column(unique = true)
	private String name;
	
	@Email(message = "The customer email should be valid.")
	@NotBlank(message = "The customer email should not be empty.")
	@Column(unique = true)
	private String email;
	
	@Column(unique = true)
	private String phone;
	
	@NotBlank(message = "The customer username should not be empty.")
	@Column(unique = true)
	private String username;
	
	@NotBlank(message = "The customer password should not be empty.")
	private String password;
	
	private boolean enabled;
	
	@CreationTimestamp
	private Date dateCreated;
	
	@UpdateTimestamp
	private Date lastUpdated;
	
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "billing_address_id")
	@JsonBackReference
	private BillingAddress billingAddress;
	
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shipping_address_id")
	@JsonBackReference
	private ShippingAddress shippingAddress;
	
	@Builder.Default
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<Cart> carts = new HashSet<>();
	
	@Builder.Default
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<Order> orders = new HashSet<>();
	
	public void addCart(Cart cart) {
		this.carts.add(cart);
		cart.setCustomer(this);
	}

	public void addOrder(Order order) {
		this.orders.add(order);
		order.setCustomer(this);
	}
}
