package com.twolak.emusicstore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.twolak.emusicstore.model.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long>{
}
