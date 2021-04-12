package com.twolak.emusicstore.model;

import lombok.Getter;

@Getter
public enum OrderStatus {
	ORDERED("Ordered"),
	SHIPPED("Sipped"),
	DELIVERED("Delivered"),
	UNABLE_TO_DELIVER("Unable to deliver"),
	CANCELED("Canceled");
	
    private final String label;

    private OrderStatus(String label) {
        this.label = label;
    }
}
