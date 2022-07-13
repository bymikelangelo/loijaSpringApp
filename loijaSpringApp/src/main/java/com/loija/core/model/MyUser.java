package com.loija.core.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Table(name="users")
@Entity
public class MyUser implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank
	@Size(min=3)
	private String firstname;
	private String surname;
	@Column(unique = true)
	@NotBlank
	@Size(min=3)
	private String username;
	@NotBlank
	@Size(min=3)
	private String password;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", 
		joinColumns = @JoinColumn(name = "user_id"), 
		inverseJoinColumns = @JoinColumn(name = "rol_id"))
	private Set<Rol> roles;
	
	public MyUser() {
		
	}
	
	public MyUser(@NotBlank String firstname, String surname, @NotBlank String username, @NotBlank String password) {
		this.firstname = firstname;
		this.surname = surname;
		this.username = username;
		this.password = password;
	}
	
	public MyUser(@NotBlank String firstname, String surname, @NotBlank String username, @NotBlank String password, Set<Rol> roles) {
		super();
		this.firstname = firstname;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	
	public MyUser(int id, @NotBlank String firstname, String surname, @NotBlank String username, @NotBlank String password, Set<Rol> roles) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "MyUser [id=" + id + ", firstname=" + firstname + ", surname=" + surname + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	
	
}
