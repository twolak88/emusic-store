package com.twolak.emusicstore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.twolak.emusicstore.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
}
