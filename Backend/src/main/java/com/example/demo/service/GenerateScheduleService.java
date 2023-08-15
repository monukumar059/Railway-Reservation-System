package com.example.demo.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.GenerateScheduleRepository;
import com.example.demo.entity.GenerateSchedule;
import com.example.demo.entity.Route;
import com.example.demo.entity.Trains;

@Service
public class GenerateScheduleService {
	@Autowired
	private GenerateScheduleRepository GenerateScheduleRepo;
	@Autowired
	private RouteService routeService;
   public Iterable<GenerateSchedule> getAllTrainSchedule()
   {
	   return GenerateScheduleRepo.getAllSchedule();
   }
	public List<Integer> getAllTrainNumbers() {
		return GenerateScheduleRepo.getTrainNo();
	}

	public Set<Integer> GetAllRouteNo() {
		return GenerateScheduleRepo.getRouteNo();
	}

	public String generateSchedule(int trainno, int route_no, String departure) {
		List<Route> route = routeService.getAllRoute();
		List<Route> route2 = new ArrayList<Route>();
		for (int i = 0; i < route.size(); i++) {
			if (route.get(i).getRoute_number() == route_no) {
				route2.add(route.get(i));
			}
		}
		float speed = GenerateScheduleRepo.getSpeedOfTrain(trainno);
		LocalTime departureTime = LocalTime.parse(departure);
		LocalTime arrivalTime = LocalTime.parse(departure);
		for (int i = 0; i < route2.size(); i++) {
			float distance = route2.get(i).getDistance();
			float result = distance / speed;
			float resultInSeconds = result * 3600;
			LocalTime time1 = LocalTime.ofSecondOfDay((long) resultInSeconds);
			LocalTime sum = time1.plusHours(departureTime.getHour()).plusMinutes(departureTime.getMinute())
					.plusSeconds(departureTime.getSecond());
			departureTime = sum;
			if (i == 0) {
				arrivalTime = null;
			} else {
				arrivalTime = departureTime.minusMinutes(10);
			}

			int len = (int) GenerateScheduleRepo.count();
			GenerateSchedule trainSchedule = new GenerateSchedule();
			trainSchedule.setId(len + 1);
			trainSchedule.setTrainNumber(trainno);
			trainSchedule.setStationName(route2.get(i).getStation_name());
			if(arrivalTime==null)
			{
				trainSchedule.setArrivalTime("-- ---");
			}
			else
			{
			trainSchedule.setArrivalTime(arrivalTime + "");
			}
			if (route2.size() - 1 == i)
				departureTime = null;
			if(departureTime==null)
			{
				trainSchedule.setDepartureTime("-- --");
			}
			else {
			trainSchedule.setDepartureTime(departureTime + "");
			}
			trainSchedule.setRouteNumber(route_no);
			GenerateScheduleRepo.save(trainSchedule);

		}
		return "Done";
	}
	
	public List<Long> trainNO(){
		List<Long> trainNo = GenerateScheduleRepo.trianNoByTrain_schedule2();
		return trainNo;
	}
	
	public List<Object> getScheduleByTrainNo(int trainNo)
	{
		return GenerateScheduleRepo.findByTrainNo(trainNo);
	}
	
	public Trains getTrainNameByNo(int TrainNo)
	{
		return GenerateScheduleRepo.getTrainName(TrainNo);
	}
	public List<Integer> getAllTrainNo()
	{
		return GenerateScheduleRepo.getTrains();
	}
 
}
