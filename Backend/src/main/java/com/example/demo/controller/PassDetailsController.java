package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.PassDetails;
import com.example.demo.service.PassDetailsService;

@RestController
public class PassDetailsController {

	@Autowired
	PassDetailsService passDetailsSer;
	@RequestMapping("/get/Passdetails")
	public Iterable<PassDetails> getAllPassengerDetails()
	{
		return passDetailsSer.getAllPassDetails();
	}
	@RequestMapping("/Add/Passdetails/{fname}/{lname}/{age}/{gender}/{mono}/{email}")
	public String AddPassengerDetails(@PathVariable("fname") String fname,
			@PathVariable("lname") String lname,@PathVariable("age") int age,@PathVariable("gender") String gender,
			@PathVariable("mono") double mono,@PathVariable("email") String email)
	{
		passDetailsSer.addDataAsArray(fname, lname, age, gender, mono, email);
		return "Added";		
	}

   @RequestMapping("/Add/PassDetails")
   public String AddPassDetails()
   {
	passDetailsSer.addPassDetails();
	   return "Added";
   }
   
   @RequestMapping("/getAllPassenger/{pnr_no}")
	public List<PassDetails> getAllPassenger(@PathVariable("pnr_no") long pnr_no){
		return passDetailsSer.getpass(pnr_no);
	}

}
