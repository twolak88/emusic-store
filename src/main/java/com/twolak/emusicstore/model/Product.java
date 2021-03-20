package com.twolak.emusicstore.model;

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
public class Product {
	private String id;
	private String  name;
	private String category;
	private String description;
	private double price;
	private String condition;
	private String status;
	private int unitInStock;
	private String manufacturer;
	
}
