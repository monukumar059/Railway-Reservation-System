package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.TrainRepository;
import com.example.demo.entity.Trains;

@Service
public class TrainService {

	@Autowired
	private TrainRepository trainRepo;
	List<Integer> listOfTrain = new ArrayList<Integer>();

	// Get all Trains
	public List<Trains> getAllTrains() {
		List<Trains> train = new ArrayList<>();
		trainRepo.findAll().forEach(train::add);
		return train;
	}

	// Get Train by Number (id)
	public Optional<Trains> getTrainByNo(long id) {
		return trainRepo.findById(id);
	}

	// Get all train that are not assigned to any route.
	public List<Trains> getNoRouteTrain() {
		List<Trains> trains = new ArrayList<>();
		trainRepo.getNoRouteTrain().forEach(trains::add);
		return trains;
	}

	public void addTrain(Trains train) {
		trainRepo.save(train);
	}

	public void updateTrain(long id, Trains train) {
		trainRepo.save(train);
	}

	public void deleteRoute(Trains train) {
		trainRepo.delete(train);
	}

	public String getTrainType(long train_number) {
		return trainRepo.findBytrain_number(train_number);
	}

	public List<Long> getTrain_number() {
		List<Long> trains = new ArrayList<>();
		trainRepo.gettrain_number().forEach(trains::add);
		return trains;
	}

	public List<Object> getTrainList() {
		List<Object> TrainDetails = new ArrayList<Object>();
		for (int i = 0; i < listOfTrain.size(); i++) {
			TrainDetails.add(trainRepo.getTrainBetweenStations(listOfTrain.get(i)));
		}
		listOfTrain = new ArrayList<Integer>();
		return TrainDetails;
	}

	public String checkTrainBetweenStation(String sourcestaion, String destinationstation) {
		if (sourcestaion.equals(destinationstation) == true) {
			return "Source and destination station can not be same";
		}
		if (trainRepo.getTrainBetweenStation(sourcestaion.trim(), destinationstation.trim()).size() == 0) {
			return "Train Between Station is not Available";
		} else {
			for (int i = 0; i < trainRepo.getTrainBetweenStation(sourcestaion, destinationstation).size(); i++) {
				listOfTrain.add(trainRepo.getTrainBetweenStation(sourcestaion, destinationstation).get(i));
			}
			return "";
		}
	}

	public Trains getTrainName(int trainName) {
		return trainRepo.getTrainBetweenStations(trainName);
	}

}


