package com.twolak.emusicstore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.twolak.emusicstore.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
