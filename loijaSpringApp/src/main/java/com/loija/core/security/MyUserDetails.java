package com.loija.core.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.loija.core.model.MyUser;
import com.loija.core.model.Rol;

public class MyUserDetails implements UserDetails{
	
	private String username;
	private String password;
    private Collection<? extends GrantedAuthority> authorities;
	

	public MyUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

	public static MyUserDetails build (MyUser user) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		Set<Rol> userRoles = user.getRoles();
		for (Rol rol : userRoles) {
			authorities.add(new SimpleGrantedAuthority(rol.getName().name())); 
		}
		return new MyUserDetails(user.getUsername(), user.getPassword(), authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
