package com.loija.core.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.loija.core.enums.Roles;
import com.loija.core.model.FactoryOrder;
import com.loija.core.model.MyUser;
import com.loija.core.model.Rol;
import com.loija.core.service.RolService;
import com.loija.core.service.UserService;

@Controller
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RolService rolService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder; 
	
	@GetMapping({"/showAll", "", "/list"})
	public ModelAndView listUsers() {
		ModelAndView mv = new ModelAndView("list-users");
		List<MyUser> users = userService.listUsers();
		mv.addObject("users", users);
		return mv;
	}
	
	@GetMapping("/addNew")
	public ModelAndView addNew() {
		ModelAndView mv = new ModelAndView("form-user");
		MyUser user = new MyUser();
		mv.addObject("user", user);
		return mv;
	}
	
	//la contraseña del usuario se codifica antes de almacenarlo en la base de datos
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute MyUser user, BindingResult result) {
		if (result.hasErrors()) {
			return "form-user";
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Set<Rol> roles = new HashSet<>();
		roles.add(rolService.getRolByName(Roles.ROLE_USER));
		user.setRoles(roles);
		userService.addUser(user);
		return "redirect:/users";
	}
	
	@GetMapping("/update")
	public ModelAndView update(@RequestParam int id) {
		ModelAndView mv = new ModelAndView("form-user");
		MyUser user = userService.getUserById(id);
		mv.addObject("user", user);
		return mv;
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam int id) {
		userService.deleteUser(id);
		return "redirect:/users";
	}
	
	
	
}
