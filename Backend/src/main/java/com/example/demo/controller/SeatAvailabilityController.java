package com.example.demo.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.SeatAvailabilityService;

@RestController
public class SeatAvailabilityController {

	@Autowired
	private SeatAvailabilityService seatAvailabilityService;

	@RequestMapping("/CheckSeatAvailability/{trainno1}/{source1}/{destination1}/{coach1}")
	public String SeatCheck(@PathVariable("trainno1") int trainno, @PathVariable("source1") String source,
			@PathVariable("destination1") String destination, @PathVariable("coach1") String coach) {
		String s = seatAvailabilityService.checkSeatAvailability(trainno, source, destination, coach);
		return s;
	}
	@RequestMapping("/updateSeatAvailability/{trainno1}/{coach1}/{passCount}")
	public void updateSeat(@PathVariable("trainno1") int trainno, @PathVariable("coach1") String coach,@PathVariable("passCount") int passCount) {
		seatAvailabilityService.UpdateSeatsAvailability(trainno, coach, passCount);
	}
	@RequestMapping("/CheckSeatAvailability2/{trainno1}/{source1}/{destination1}/{coach1}/{travel_Date}")
	public String SeatCheck2(@PathVariable("trainno1") int trainno, @PathVariable("source1") String source,
			@PathVariable("destination1") String destination, @PathVariable("coach1") String coach, @PathVariable("travel_Date") Date travel_Date ) {
		String s = seatAvailabilityService.checkSeatAvailability2(trainno, source, destination, coach , travel_Date);
		return s;
	}
}
