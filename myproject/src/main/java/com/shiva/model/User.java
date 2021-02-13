package com.shiva.model;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document
public class User {

	@Id
	private String id;
	private String name;
	private String email;
	private String role;
	private String status;
	
	
	
	public User() {
	}

	public User(String id, String name, String email, String role, String status) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", role=" + role + ", status=" + status + "]";
	}
	
	
	
	
}
