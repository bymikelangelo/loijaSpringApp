package com.loija.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.loija.core.enums.TypesProduct;

@Table(name="typesproduct")
@Entity
public class TypeProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
    @NotNull
    @Column(unique = true)
	private TypesProduct name;
	
	public TypeProduct() {
		super();
	}
	
	public TypeProduct(TypesProduct name) {
		super();
		this.name = name;
	}
	
	public TypeProduct(int id, TypesProduct name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public TypesProduct getName() {
		return name;
	}
	
	public void setName(TypesProduct name) {
		this.name = name;
	}
	
	
}
