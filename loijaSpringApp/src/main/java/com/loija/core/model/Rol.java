package com.loija.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.loija.core.enums.Roles;

@Table(name="roles")
@Entity
public class Rol implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(unique = true)
    private Roles name;
    
    public Rol() {
    	
    }

    public Rol(@NotNull Roles name) {
        this.name = name;
    }
    
	public Rol(int id, @NotNull Roles name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Roles getName() {
		return name;
	}

	public void setName(Roles name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name.name();
	}
	
	

}
