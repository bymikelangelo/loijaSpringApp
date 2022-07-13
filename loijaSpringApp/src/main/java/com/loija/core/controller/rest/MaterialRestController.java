package com.loija.core.controller.rest;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loija.core.model.Material;
import com.loija.core.model.Product;
import com.loija.core.service.MaterialService;

@RestController
@RequestMapping("rest/materials")
public class MaterialRestController {
	
	@Autowired
	private MaterialService materialService;
	
	@GetMapping({"", "/list"})
	public List<Material> listMaterials() {
		return materialService.listMaterials();
	}
	
	@GetMapping("/list/productId/{productId}")
	public List<Material> listMaterials(@PathVariable(value="productId") int productId) {
		return materialService.listMaterials(productId);
	}
	
	@PostMapping("/listByProduct")
	public List<Material> listMaterialsByProduct(@RequestBody Product product) {
		return materialService.listMaterialsByProduct(product);
	}

}
