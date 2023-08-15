package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.RegisterService;


@RestController
public class RegisterController{
	@Autowired
    private RegisterService registerService;
	@RequestMapping("/Register/User/{id}")
	public boolean getAllUserId(@PathVariable("id") String id)
	{
		return registerService.getAllUserid(id);
	}
	@RequestMapping("/Register/Email/{id}")
	public boolean getAllEmail(@PathVariable("id") String id)
	{
		return registerService.getAllEmail(id);
	}
	@RequestMapping("/Register/MobileNo/{mo}")
	public boolean getAllMobileNo(@PathVariable("mo") long mo)
	{
		return registerService.getAllMobileNo(mo);
	}
	@RequestMapping("/Register/AddAllData/{userId}/{password}/{confirmPassword}/{fullName}/{gender}/{dateOfBirth}/{email}/{mobileNo}/{streetLine}/{city}/{pinCode}/{aadharNo}/{country}/{nationality}")
	public boolean AddDataToRegister(@PathVariable("userId") String userId, @PathVariable("password") String password, 
			@PathVariable("confirmPassword") String confirmPassword, @PathVariable("fullName") String fullName, 
			@PathVariable("gender") String gender,@PathVariable("dateOfBirth") LocalDate dateOfBirth,
			@PathVariable("email") String email,@PathVariable("mobileNo") long mobileNo, 
			@PathVariable("streetLine") String streetLine, @PathVariable("city") String city,
			@PathVariable("pinCode") Integer pinCode,@PathVariable("aadharNo") long aadharNo, 
			@PathVariable("country") String country,@PathVariable("nationality") String nationality) {

        registerService.addAllData(userId, password, confirmPassword, fullName, gender, dateOfBirth,
                email, mobileNo, aadharNo, streetLine, city, pinCode, country, nationality);
        return true;
    }
	@RequestMapping("/GetId/{id}")
	public String getId(@PathVariable("id") String Id)
	{
		System.out.println("Called By Booking");
		if(registerService.getUserId(Id)>0)
			return "";
		else
			return "User Not Found";
	}
	@RequestMapping("/Register/checkPassword/{userId}/{password}")
	public boolean checkPassword(@PathVariable("userId") String userId, @PathVariable("password") String password) {
		return registerService.checkPassword(userId, password);
	}

	@RequestMapping("/Register/updatePasswordAndconfirmPassword/{userId}/{password}/{confirmPassword}")
	public String updatePasswordAndConfirmPassword(@PathVariable("userId") String userId,
			@PathVariable("password") String password, @PathVariable("confirmPassword") String confirmPassword) {
		registerService.updatePasswordAndConfirmPassword(userId, password, confirmPassword);
		return "your Password has been update";
	}
}
