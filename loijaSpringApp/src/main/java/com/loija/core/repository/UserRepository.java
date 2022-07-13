package com.loija.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loija.core.model.MyUser;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Integer> {

	public MyUser findByUsername(String username);
	
}
