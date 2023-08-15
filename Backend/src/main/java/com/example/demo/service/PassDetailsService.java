package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.BookingDetailsRepository;
import com.example.demo.Repository.PassDetailsRepository;
import com.example.demo.entity.PassDetails;

@Service
public class PassDetailsService {
	@Autowired
	PassDetailsRepository passDetailsRepo;
	@Autowired
	BookingDetailsRepository bookingDetail;
	static int id = 100;
	static long pnrNo = 1234567;
	List<PassDetails> PassData = new ArrayList<PassDetails>();

	public String addDataAsArray(String fname, String lname, int age, String gender, double moNo, String email) {
		PassDetails details;
		if (passDetailsRepo.getId().size() == 0) {
			details = new PassDetails(100, fname, lname, age, gender, moNo, email, pnrNo + bookingDetail.count());
		} else {
			details = new PassDetails(passDetailsRepo.getId().get(0) + 1 + PassData.size(), fname, lname, age, gender,
					moNo, email, pnrNo + bookingDetail.count());

		}
		PassData.add(details);
		System.out.println(PassData.get(0).getEmail());
		return "Done";
	}

	public Iterable<PassDetails> getAllPassDetails() {
		return passDetailsRepo.findAll();
	}

	public void addPassDetails() {
		System.out.println(PassData);
		for (int i = 0; i < PassData.size(); i++) {
			passDetailsRepo.save(PassData.get(i));
			
		}
	}
	
	public List<PassDetails> getpass(long pnr_no) {
		return passDetailsRepo.findByPnrNo(pnr_no);
	}
	
	public List<PassDetails> getPass(long pnrNo){
		List<PassDetails> pass = new ArrayList<>();
		passDetailsRepo.findByPnrNo(pnrNo).forEach(pass::add);
		return pass;
	}
}