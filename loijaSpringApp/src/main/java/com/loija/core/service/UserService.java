package com.loija.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loija.core.model.MyUser;
import com.loija.core.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public MyUser addUser(MyUser user) {
		return repository.save(user);
	}
	
	public List<MyUser> listUsers() {
		return repository.findAll();
	}
	
	public String deleteUser(int id) {
		try {
			Optional<MyUser> user = repository.findById(id);
			repository.delete(user.get());
			return "Usuario eliminado";
		}
		catch (Exception e) {
			return "Se ha producido un error";
		}
	}
	
	public MyUser getUserById(int id) {
		return repository.findById(id).get();
	}
	
	public MyUser getUserByUsername(String username) {
		return repository.findByUsername(username);
	}
	
}
