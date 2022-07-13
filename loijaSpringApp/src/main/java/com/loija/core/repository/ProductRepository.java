package com.loija.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loija.core.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
