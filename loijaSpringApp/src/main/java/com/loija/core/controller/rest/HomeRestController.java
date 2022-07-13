package com.loija.core.controller.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.loija.core.model.MyUser;
import com.loija.core.service.UserService;

@RestController
@RequestMapping("rest")
public class HomeRestController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/validate")
	public String validate() {
		return "VALIDATION_SUCCESFULL";
	}

	@GetMapping("/login")
	public MyUser login(@RequestHeader("username") String username) {
		return userService.getUserByUsername(username);
	}
	
	@GetMapping("/logout")
	public String logout() {
		HttpServletRequest r = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(r, null, auth);
            
        }
		return "LOGOUT_SUCCESFULL";
	}
	
}
