package com.twolak.emusicstore.repositories;

import org.springframework.data.repository.CrudRepository;

import com.twolak.emusicstore.model.Cart;

public interface CartRepository extends CrudRepository<Cart, String>{
}
