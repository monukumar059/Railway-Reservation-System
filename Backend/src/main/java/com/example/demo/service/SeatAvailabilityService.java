package com.example.demo.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.GenerateScheduleRepository;

@Service
public class SeatAvailabilityService {
	@Autowired
	private GenerateScheduleRepository generateScheduleRepository;
	@Autowired
	private BookingDetailsService bookingService;

	public String checkSeatAvailability(int trainno, String sourcestaion, String destinationstation, String coachType) {
		if (generateScheduleRepository.getSourceStation(sourcestaion.trim(), trainno).size() >= 1
				&& generateScheduleRepository.getDestiStaion(destinationstation.trim(), trainno).size() >= 1) {
			if (sourcestaion.equals(destinationstation)) {
				return "Source and destination station can not be same";
			} else if (coachType.equals("2A")) {
				return generateScheduleRepository.get2ATotalSeats(trainno) + "";
			} else {
				return generateScheduleRepository.get3ATotalSeats(trainno) + "";
			}
		} else {
			return "Train Between Station is not Available";
		}
	}
	public String checkSeatAvailability2(int trainno, String sourcestaion, String destinationstation, String coachType, Date travel_Date) {
		if (generateScheduleRepository.getSourceStation(sourcestaion.trim(), trainno).size() >= 1
				&& generateScheduleRepository.getDestiStaion(destinationstation.trim(), trainno).size() >= 1) {
			String a3pass = generateScheduleRepository.get3ATotalSeats(trainno);
			String a2pass= generateScheduleRepository.get2ATotalSeats(trainno);
			if (sourcestaion.equals(destinationstation)) {
				return "Source and destination station can not be same";
			} else if (coachType.equals("2A")) {
				return Integer.parseInt(a2pass) - bookingService.A2PassengerCount(trainno, travel_Date) + "";
			}
			else {
				return Integer.parseInt(a3pass) - bookingService.A3PassengerCount(trainno, travel_Date) + "";
			}
		} else {
			return "Train Between Station is not Available";
		}
	}
	public void UpdateSeatsAvailability(int trainNo, String caoch, int passengerCount) {
		if (caoch.equals("2A")) {
			String Seats = generateScheduleRepository.get2ATotalSeats(trainNo);
			int seats = Integer.parseInt(Seats) - passengerCount;
			generateScheduleRepository.update2ASeats(seats, trainNo);
		}
		if (caoch.equals("3A")) {
			String Seats = generateScheduleRepository.get3ATotalSeats(trainNo);
			int seats = Integer.parseInt(Seats) - passengerCount;
			generateScheduleRepository.update3ASeats(seats, trainNo);
		}
	}
}
