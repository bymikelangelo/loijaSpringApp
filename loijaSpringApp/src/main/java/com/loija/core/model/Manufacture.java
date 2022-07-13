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

import com.loija.core.enums.Manufactures;

@Table(name="manufactures")
@Entity
public class Manufacture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(unique = true)
	private Manufactures name;
	
    
	public Manufacture() {
		super();
	}


	public Manufacture(Manufactures name) {
		super();
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Manufactures getName() {
		return name;
	}


	public void setName(Manufactures name) {
		this.name = name;
	}
	
	
	
}
