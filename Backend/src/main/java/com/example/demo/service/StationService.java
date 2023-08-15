package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.StationRepository;
import com.example.demo.entity.Station;

@Service
public class StationService {

	@Autowired
	private StationRepository stationRepo;

	public List<Station> getAllStation() {
		List<Station> station = new ArrayList<>();
		stationRepo.findAll().forEach(station::add);
		return station;
	}

	public Optional<Station> getStationByNo(String id) {
		return stationRepo.findById(id);
	}

	public void addStation(Station station) {
		stationRepo.save(station);
	}

	public void updateStation(String id, Station station) {
		stationRepo.save(station);
	}

	public void deleteRoute(Station Station) {
		stationRepo.delete(Station);
	}

	public List<String> getStation_name() {
		List<String> stationName = new ArrayList<>();
		stationRepo.getStationName().forEach(stationName::add);
		return stationName;
	}
}
