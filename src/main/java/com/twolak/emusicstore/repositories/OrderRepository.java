package com.twolak.emusicstore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.twolak.emusicstore.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{
}
