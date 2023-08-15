package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Route;
import com.example.demo.service.RouteService;

@RestController
public class RouteController {

	@Autowired
	private RouteService routeService;
	
	@RequestMapping("/route")
	public List<Route> getAllRoute() {
		return routeService.getAllRoute();
	}
	
	@RequestMapping("/route/{id}")
	public Optional<Route> getFare(@PathVariable long id) {
		return routeService.getRoute(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/route")
	public void addRoute(@RequestBody Route route) {
		routeService.addRoute(route);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/route/{id}")
	public void updateRoute(@RequestBody Route route, @PathVariable long id) {
		routeService.updateRoute(id, route);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/route/{id}")
	public void deleteRoute(@PathVariable Route id) {
		routeService.deleteRoute(id);
	}
	
	@RequestMapping("/stations/{station_name}")
	public List<Route> getAllStation_name(@PathVariable String station_name) {
		return routeService.getAllStation_name(station_name);
	}
	
	@RequestMapping("/station/{station_name}")
	public Integer getStation_name(@PathVariable String station_name) {
		return routeService.getStation_name(station_name);
	}
	
	
}
