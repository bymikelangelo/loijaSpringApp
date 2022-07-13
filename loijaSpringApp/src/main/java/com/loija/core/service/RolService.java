package com.loija.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loija.core.enums.Roles;
import com.loija.core.model.Rol;
import com.loija.core.repository.RolRepository;

@Service
public class RolService {

	@Autowired
	private RolRepository repository;
	
	public Rol addRol(Rol role) {
		return repository.save(role);
	}
	
	public List<Rol> listRoles() {
		return repository.findAll();
	}
	
	public Rol getRolById(int id) {
		return repository.findById(id).get();
	}
	
	public Rol getRolByName(Enum<Roles> name) {
		return repository.findByName(name);
	}
}
