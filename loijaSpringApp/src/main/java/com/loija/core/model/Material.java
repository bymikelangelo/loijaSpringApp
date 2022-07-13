package com.loija.core.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="materials")
@Entity
public class Material {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToOne()
	@JoinTable(name = "materials_products", 
		joinColumns = @JoinColumn(name = "material_id"),
		inverseJoinColumns = @JoinColumn(name = "product_id"))
	private Product product;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "materials_manufactures", 
		joinColumns = @JoinColumn(name = "material_id"),
		inverseJoinColumns = @JoinColumn(name = "manufacture_id"))
	private Set<Manufacture> manufactures;
	
	public Material() {
		super();
	}

	public Material(String name, Product product, Set<Manufacture> manufactures) {
		super();
		this.name = name;
		this.product = product;
		this.manufactures = manufactures;
	}
	
	public Material(int id, String name, Product product, Set<Manufacture> manufactures) {
		super();
		this.id = id;
		this.name = name;
		this.product = product;
		this.manufactures = manufactures;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Set<Manufacture> getManufactures() {
		return manufactures;
	}

	public void setManufactures(Set<Manufacture> manufactures) {
		this.manufactures = manufactures;
	}
	
}
