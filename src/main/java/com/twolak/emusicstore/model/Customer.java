package com.twolak.emusicstore.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
	
	@NotBlank(message = "The customer name shouldn't be empty.")
	private String name;
	
	@NotBlank(message = "The customer email shouldn't be empty.")
	private String email;
	
	private String phone;
	
	@NotBlank(message = "The customer username shouldn't be empty.")
	private String username;
	
	@NotBlank(message = "The customer password shouldn't be empty.")
	private String password;
	
	private boolean enabled;
	
	@OneToOne
	@JoinColumn(name = "billing_address_id")
	@JsonBackReference
	private BillingAddress billingAddress;
	
	@OneToOne
	@JoinColumn(name = "shipping_address_id")
	@JsonBackReference
	private ShippingAddress shippingAddress;
	
	@Builder.Default
	@OneToMany(mappedBy = "customer")
	@JsonManagedReference
	private Set<Cart> carts = new HashSet<>();
	
	@Builder.Default
	@OneToMany(mappedBy = "customer")
	@JsonManagedReference
	private Set<Order> orders = new HashSet<>();
}
