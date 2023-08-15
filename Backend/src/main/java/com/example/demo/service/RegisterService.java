package com.example.demo.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.RegisterRepository;
import com.example.demo.entity.Register;

@Service
public class RegisterService {
	@Autowired
	RegisterRepository RegisterRepo;

	public boolean getAllUserid(String UserName) {
		if (RegisterRepo.getListOfUserId().contains(UserName) == true) {
			return true;
		} else
			return false;
	}

	public boolean getAllEmail(String mail) {
		if (RegisterRepo.getListOfEmail().contains(mail) == true) {
			return true;
		} else
			return false;
	}

	public boolean getAllMobileNo(long mo) {
		if (RegisterRepo.getListOfmobileNo().contains(mo) == true) {
			return true;
		} else
			return false;
	}

	public void addAllData(String user_id, String password, String confirm_password, String full_name, String gender,
			LocalDate date_of_birth, String email, long mobile_no, long aadhar_no, String street_line, String city,
			Integer pin_code, String country, String nationality) {
		Register register = new Register(user_id, password, confirm_password, full_name, gender, date_of_birth, email,
				mobile_no, aadhar_no, street_line, city, pin_code, country, nationality);
		RegisterRepo.save(register);
	}

	public int getUserId(String id) {
		return RegisterRepo.getUserId(id).size();
	}
	
	public boolean checkPassword(String id , String password) {
		if(RegisterRepo.getPassword(id).equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void updatePasswordAndConfirmPassword(String user_id, String password, String confirm_password) {
		RegisterRepo.updatePasswordAndConfirmPassword(user_id, password, confirm_password);
	}
}
