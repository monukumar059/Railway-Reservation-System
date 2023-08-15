package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.RouteRepository;
import com.example.demo.entity.Route;

@Service
public class RouteService {

	@Autowired
	private RouteRepository routeRepo;

	public Optional<Route> getRoute(long id) {
		return routeRepo.findById(id);
	}

	public void addRoute(Route route) {
		routeRepo.save(route);
	}

	public void updateRoute(long id, Route route) {
		routeRepo.save(route);
	}

	public void deleteRoute(Route route) {
		routeRepo.delete(route);
	}

	public List<Route> getAllStation_name(String Station_name) {
		List<Route> route = new ArrayList<>();
		routeRepo.findByAllStation_name(Station_name).forEach(route::add);
		;
		return route;
	}

	public Integer getStation_name(String station_name) {
		Integer result = routeRepo.findByStation_name(station_name);
		System.out.println("testing for station name " + result);
		System.out.println("testing for station name " + routeRepo.findByStation_name(station_name));
//	    return result != null ? result : 0;
		return routeRepo.findByStation_name(station_name);
	}
	
	public List<Route> getAllRoute() {
		return routeRepo.getAllRoutes();
	}

}
