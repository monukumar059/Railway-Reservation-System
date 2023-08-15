package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.FareRepository;
import com.example.demo.Repository.GenerateScheduleRepository;
import com.example.demo.Repository.RouteRepository;
import com.example.demo.Repository.TrainRepository;
import com.example.demo.entity.GenerateSchedule;

@Service
public class FareCalculationService {

	@Autowired
	private RouteRepository routeRepo;
	
	@Autowired
	private FareRepository fareRepo;
	
	@Autowired
	private TrainRepository trainRepo;
	@Autowired
	private GenerateScheduleRepository generateScheduleRepository;
	

	public Integer getFromStation_name(String fromStation) {
		System.out.println(routeRepo.findByStation_name(fromStation));
		return routeRepo.findByStation_name(fromStation.trim());
	}
	
	public Integer getToStation_name(String toStation) {
		System.out.println(routeRepo.findByStation_name(toStation));
		return routeRepo.findByStation_name(toStation.trim());
	}
	
	public String getTrainType(long train_number) {
		System.out.println(trainRepo.findBytrain_number(train_number));
		return trainRepo.findBytrain_number(train_number);
	}
	
	public Integer getFareByTraintype(long train_number, String coach_type) {
		System.out.println(fareRepo.findByTrainType(getTrainType(train_number), coach_type));
		return fareRepo.findByTrainType(getTrainType(train_number), coach_type);
	}
	
	public String getFare(String fromStation, String toStation, long train_number, String coach_type) {
		int dis = getToStation_name(toStation.trim())- getFromStation_name(fromStation.trim());
		int fare = getFareByTraintype(train_number, coach_type);
		int fare1 = dis*fare;
		List<GenerateSchedule> list = (List<GenerateSchedule>) generateScheduleRepository.findAll();
		List<String> Station = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTrainNumber() == train_number)
				Station.add(list.get(i).getStationName());
//			System.out.println(Station.add(list.get(i).getStation_name()));
		}
		int x = 0, y = 0;
		for (int i = 0; i < Station.size(); i++) {
			if (Station.get(i).equalsIgnoreCase(fromStation.trim())) {
				x++;
				System.out.println(x);
			}
			if (Station.get(i).equalsIgnoreCase(toStation))
				y++;

		}
		if (x == 0 || y == 0) {
			return "Train Between Station is not Available";
		} 
		else {	
			if(fare1<0) {
				return "" +fare1*-1;				
			}
			else {
				return " " +fare1;	
			}
		}
	}
	

}