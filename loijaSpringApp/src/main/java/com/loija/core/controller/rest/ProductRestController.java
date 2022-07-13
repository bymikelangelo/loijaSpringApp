package com.loija.core.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loija.core.model.Product;
import com.loija.core.service.ProductService;

@RestController
@RequestMapping("rest/products")
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping({"", "/list"})
	public List<Product> listProduct() {
		return productService.listProducts();
	}

}
