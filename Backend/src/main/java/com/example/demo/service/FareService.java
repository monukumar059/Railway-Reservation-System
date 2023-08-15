package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.FareRepository;
import com.example.demo.entity.Fare;

@Service
public class FareService {

	
	@Autowired
	private FareRepository fareRepo;
	
	public List<Fare> getAllFare() {
		List<Fare> fare = new ArrayList<>();
		fareRepo.findAll().forEach(fare::add);
		return fare;
	}
	
	public Optional<Fare> getFare(long id) {
		return fareRepo.findById(id);
	}
	
	public void addFare(Fare fare) {
		fareRepo.save(fare); 
	}
	
	public void updateFare(long id, Fare fare) {
		fareRepo.save(fare);
	}
	
	public void deleteFare(Fare fare) {
		fareRepo.delete(fare); 
	}
	
	public Integer getFareByTraintype(String train_type,String coach_type) {
		return fareRepo.findByTrainType(train_type,coach_type);
	}
	
}
