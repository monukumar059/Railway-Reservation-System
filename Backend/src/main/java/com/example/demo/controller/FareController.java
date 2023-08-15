
package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Fare;
import com.example.demo.service.FareCalculationService;
import com.example.demo.service.FareService;

@RestController
public class FareController {

	@Autowired
	private FareService fareService;
	@Autowired
	private FareCalculationService calculation;

	@RequestMapping("/fare")
	public List<Fare> getAllFare() {
		return fareService.getAllFare();
	}

	@RequestMapping("/fare/{id}")
	public Optional<Fare> getFare(@PathVariable long id) {
		return fareService.getFare(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/fare")
	public void addFare(@RequestBody Fare fare) {
		fareService.addFare(fare);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/fare/{id}")
	public void updateFare(@RequestBody Fare fare, @PathVariable long id) {
		fareService.updateFare(id, fare);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/fare/{id}")
	public void deleteFare(@PathVariable Fare id) {
		fareService.deleteFare(id);
	}

	@RequestMapping("/fares/{train_type}")
	public Integer getFareByTraintype(@PathVariable String train_type, @PathVariable String coach_type) {
		return fareService.getFareByTraintype(train_type, coach_type);
	}

	@RequestMapping("/fares/{fromStation}/{toStation}/{train_number}/{coach_type}")
	public String getFareBy(@PathVariable String fromStation, @PathVariable String toStation,
			@PathVariable long train_number, @PathVariable String coach_type) {
		return calculation.getFare(fromStation.trim(), toStation.trim(), train_number, coach_type.trim());

	}
	

}
