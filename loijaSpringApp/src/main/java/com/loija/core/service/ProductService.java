package com.loija.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loija.core.model.Product;
import com.loija.core.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	public ProductRepository repository;
	
	public List<Product> listProducts() {
		return repository.findAll();
	}

}
