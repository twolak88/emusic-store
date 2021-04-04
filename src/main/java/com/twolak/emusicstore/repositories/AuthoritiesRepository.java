package com.twolak.emusicstore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.twolak.emusicstore.model.Authorities;

@Repository
public interface AuthoritiesRepository extends CrudRepository<Authorities, Long> {
}