package com.loija.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loija.core.model.Material;
import com.loija.core.model.Product;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer>{

	public List<Material> getByProduct(Product product);
}
