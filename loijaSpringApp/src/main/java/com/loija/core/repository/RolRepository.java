package com.loija.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loija.core.enums.Roles;
import com.loija.core.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{

	public Rol findByName(Enum<Roles> name);
}
