package com.twolak.emusicstore.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.multipart.MultipartFile;

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
@Table(name = "products")
public class Product implements Serializable {
	
	private static final long serialVersionUID = -5024705348324768489L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotBlank(message = "The product name must not be blank")
	@Column(name = "name")
	private String  name;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "description")
	private String description;
	
	@Min(value = 0, message = "The product price must not be less than zero")
	@Column(name = "price")
	private double price;
	
	@Column(name = "prod_condition")
	private String condition;
	
	@Column(name = "status")
	private String status;
	
	@Min(value = 0, message = "The product unit in stock must not be less than zero")
	@Column(name = "unit_in_stock")
	private int unitInStock;
	
	@Column(name = "manufacturer")
	private String manufacturer;
	
	@Column(name = "product_image_url")
	private String imageUrl;
	
	@CreationTimestamp
	@Column(updatable = false)
	private Date dateCreated;
	
	@UpdateTimestamp
	private Date lastUpdated;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Transient
	private MultipartFile image;
	
	@Builder.Default
	@OneToMany(mappedBy="product")
	@JsonBackReference
	private Set<CartItem> cartItems = new HashSet<>();
}
