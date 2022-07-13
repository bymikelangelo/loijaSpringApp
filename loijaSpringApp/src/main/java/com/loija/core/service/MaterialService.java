package com.loija.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loija.core.model.Material;
import com.loija.core.model.Product;
import com.loija.core.repository.MaterialRepository;
import com.loija.core.repository.ProductRepository;

@Service
public class MaterialService {

	@Autowired
	private MaterialRepository materialRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Material> listMaterials() {
		return materialRepository.findAll();
	}
	
	public List<Material> listMaterials(int idProduct) {
		Product product = productRepository.findById(idProduct).get();
		return materialRepository.getByProduct(product);
	}
	
	public List<Material> listMaterialsByProduct(Product product) {
		return materialRepository.getByProduct(product);
	}
}
