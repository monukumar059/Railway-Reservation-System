package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AdminDetailsService;

@RestController
public class AdminController {

	@Autowired
	private AdminDetailsService  adminService;
	
	@RequestMapping("Register/Admin/{adminId}")
	public boolean getAllUserId(@PathVariable("adminId") String adminId) {
		return adminService.getAllAdminid(adminId);
	}
	
	@RequestMapping("/Register/checkAdminPassword/{adminId}/{password}")
	public boolean checkPassword(@PathVariable("adminId") String adminId, @PathVariable("password") String password) {
		return adminService.checkAdminPassword(adminId, password);
	}
}