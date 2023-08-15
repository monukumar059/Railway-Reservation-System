package com.example.demo.controller;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.GenerateSchedule;
import com.example.demo.entity.Trains;
import com.example.demo.service.GenerateScheduleService;

@RestController
public class GenerateScheduleController {
	@Autowired
	private GenerateScheduleService generateScheduleService;
	@RequestMapping(value = "/admin/getAllTrains/schedule", method = RequestMethod.GET)
	public Iterable<com.example.demo.entity.GenerateSchedule> getAllTrainSchedule() {
		return generateScheduleService.getAllTrainSchedule();
	}
	@RequestMapping(value = "/admin/getAllTrains", method = RequestMethod.GET)
	public List<Integer> getAllTrains() {
		return generateScheduleService.getAllTrainNumbers();
	}

	@RequestMapping(value = "/admin/getAllRoutes", method = RequestMethod.GET)
	public Set<Integer> getAllRouteNos() {
		return generateScheduleService.GetAllRouteNo();
	}

	@RequestMapping(value = "/admin/generateSchedule/{trainno}/{route_no}/{departure}")
	public String GenerateSchedule(@PathVariable("trainno") int trainno, @PathVariable("route_no") int route_no,
			@PathVariable("departure") String departure) {
		String s = generateScheduleService.generateSchedule(trainno, route_no, departure);
		if (s.equals("Done"))
			return "Schedule Generated Successfully";
		else
			return "Something went wrong";

	}
	
	@RequestMapping(value = "/admin/getAllTrainsNo", method = RequestMethod.GET)
	public List<Long> getAllTrainsNo() {
		return generateScheduleService.trainNO();
	}
	@RequestMapping(value = "/admin/TrainSchedule/{TrainNo}")
	public List<Object> getByTrainsNo(@PathVariable("TrainNo") int TrainNo) {
		return generateScheduleService.getScheduleByTrainNo(TrainNo);
	}
	@RequestMapping(value = "/admin/TrainName/{TrainNo}")
	public Trains getByTrainsName(@PathVariable("TrainNo") int TrainNo) {
		return generateScheduleService.getTrainNameByNo(TrainNo);
	}
	@RequestMapping(value = "/admin/getAllTrainNumbers", method = RequestMethod.GET)
	public List<Integer> getAllTrainsName() {
		return generateScheduleService.getAllTrainNo();
	}

}
