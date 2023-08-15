package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin_details")
public class AdminDetails {

	@Id
	@Column(name = "admin_id")
	private String adminId;
	
	@Column(name = "password")
	private String passwoed;
	
	@Column(name = "user_id")
	private String userId;

	public AdminDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminDetails(String adminId, String passwoed, String userId) {
		super();
		this.adminId = adminId;
		this.passwoed = passwoed;
		this.userId = userId;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getPasswoed() {
		return passwoed;
	}

	public void setPasswoed(String passwoed) {
		this.passwoed = passwoed;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}