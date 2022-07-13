package com.loija.core.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.loija.core.model.MyUser;
import com.loija.core.model.Rol;
import com.loija.core.service.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired 
	private UserService service;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MyUser user = service.getUserByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("Usuario no encontrado.");
		}
		
		return MyUserDetails.build(user);
	}
	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		MyUser user = service.getUserByUsername(username);
//		UserBuilder userBuilder = null;
//		
//		if (user != null) {
//			userBuilder = User.withUsername(username);
//			userBuilder.disabled(false);
//			userBuilder.password(user.getPassword());
//			
//			System.out.println(user.toString());
//			
//			List<GrantedAuthority> authorities = new ArrayList<>();
//			Set<Rol> userRoles = user.getRoles();
//			for (Rol rol : userRoles) {
//				authorities.add(new SimpleGrantedAuthority(rol.getName().name())); 
//			}
//			
//			userBuilder.authorities(authorities);
//			
//		}
//		else {
//			System.out.println("Usuario no encontrado.");
//			throw new UsernameNotFoundException("Usuario no encontrado.");
//		}
//		
//		return userBuilder.build();
//	}

}
