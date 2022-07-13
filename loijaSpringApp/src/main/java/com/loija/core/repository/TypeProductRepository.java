package com.loija.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loija.core.model.TypeProduct;

@Repository
public interface TypeProductRepository extends JpaRepository<TypeProduct, Integer>{

}
