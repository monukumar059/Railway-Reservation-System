package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Trains;
import com.example.demo.service.TrainService;

@RestController
public class TrainController {

	@Autowired
	private TrainService trainService;
	
	//API to Get all Train details
	@RequestMapping("/getAllTrains")
	public List<Trains> getAllTrains() {
		return trainService.getAllTrains();
	}
	
	@RequestMapping("/getTrainByNo./{trainNumber}")
	public Optional<Trains> geTrainByNo(@PathVariable long trainNumber) {
		return trainService.getTrainByNo(trainNumber);
	}
	
	//API to Get all train details that are not assigned to any route.
	@RequestMapping(value = "/getNoRouteTrain",method=RequestMethod.GET)
	public List<Trains> getNoRouteTrain() {
		return trainService.getNoRouteTrain();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addTrain")
	public void addTrain(@RequestBody Trains train) {
		trainService.addTrain(train);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/updateTrain/{id}")
	public void updateTrain(@RequestBody Trains train, @PathVariable long id) {
		trainService.updateTrain(id, train);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteTrain/{id}")
	public void deleteTrain(@PathVariable Trains id) {
		trainService.deleteRoute(id);
	}
	
	@RequestMapping("/type/{train_number}")
	public String getTrainType(@PathVariable long train_number) {
		return trainService.getTrainType(train_number);
	}
	
	@RequestMapping("/getAllTrainNumbers")
	public List<Long> getTrain_number() {
		return trainService.getTrain_number();
	}
	
	@RequestMapping("/get/TrainNoByStation/{Sstation}/{Dstation}")
	public String getTrainNoByStation(@PathVariable String Sstation,@PathVariable String Dstation) {
		return trainService.checkTrainBetweenStation(Sstation, Dstation);
	}
	
	@RequestMapping("/get/TrainNoDetails")
	public List<Object> getTrainNoDetails() {
		return trainService.getTrainList();
	}
	
	
	@RequestMapping(value = "/get/TrainName/{TrainNo}")
	public Trains getByTrainsName(@PathVariable("TrainNo") int TrainNo) {
		return trainService.getTrainName(TrainNo);
	}

	
}
