package com.loija.core.controller.rest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loija.core.enums.Roles;
import com.loija.core.model.MyUser;
import com.loija.core.model.Rol;
import com.loija.core.service.RolService;
import com.loija.core.service.UserService;

@RestController
@RequestMapping("rest/users")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RolService rolService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder; 

	@GetMapping({"", "/list"})
	public List<MyUser> listUsers() {
		return userService.listUsers();
	}
	
	@GetMapping("/get/id/{id}")
	public MyUser getById(@PathVariable(value = "id") int id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/get/username/{username}")
	public MyUser getByUsername(@RequestParam String username) {
		return userService.getUserByUsername(username);
	}
	
	@PostMapping("/save")
	public MyUser save(@RequestBody MyUser user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Set<Rol> roles = new HashSet<>();
		roles.add(rolService.getRolByName(Roles.ROLE_USER));
		user.setRoles(roles);
		return userService.addUser(user);
	}
	
	@GetMapping("/delete")
	public void delete(@RequestParam int id) {
		userService.deleteUser(id);
	}
}
