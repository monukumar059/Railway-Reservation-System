package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.StationService;

@RestController
public class StationController {

	@Autowired
	private StationService stationService;
	
	@RequestMapping("/AllStation_Name")
	public List<String> getStatonName(){
		return stationService.getStation_name();
	}
	
}
