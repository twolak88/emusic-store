package com.twolak.emusicstore.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
public class Order implements Serializable {
	
	private static final long serialVersionUID = -9081705810883360431L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "cart_id")
	@JsonBackReference
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name = "castomer_id")
	@JsonBackReference
	Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "billing_address_id")
	@JsonBackReference
	private BillingAddress billingAddress;
	
	@ManyToOne
	@JoinColumn(name = "shipping_address_id")
	@JsonBackReference
	private ShippingAddress shippingAddress;
}
