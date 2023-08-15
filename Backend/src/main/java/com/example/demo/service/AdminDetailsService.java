package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.AdminRepository;

@Service
public class AdminDetailsService {
	
	@Autowired
	private AdminRepository adminRepo;
	
	public boolean getAllAdminid(String adminId) {
		if (adminRepo.getListOfAdminId().contains(adminId) == true) {
			return true;
		} else
			return false;
	}
	
	public boolean checkAdminPassword(String id , String password) {
		if(adminRepo.getPassword(id).equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}

}