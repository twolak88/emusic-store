package com.twolak.emusicstore.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "billing_addresses")
public class BillingAddress implements Serializable {
	
	private static final long serialVersionUID = 8886592032910244193L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "The Street Name should not be empty.")
	private String streetName;
	
	@NotBlank(message = "The Apartment Number should not be empty.")
	private String apartmentNumber;
	
	@NotBlank(message = "The City should not be empty.")
	private String city;
	
	@NotBlank(message = "The State should not be empty.")
	private String state;
	
	@NotBlank(message = "The Country should not be empty.")
	private String country;
	
	@NotBlank(message = "The Zip Code should not be empty.")
	private String zipCode;
	
	@OneToOne(mappedBy = "billingAddress")
	@JsonManagedReference
	private Customer customer;

	@Override
	public String toString() {
		return "BillingAddress [streetName=" + streetName + ", apartmentNumber=" + apartmentNumber + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", zipCode=" + zipCode + "]";
	}
	
	
}
