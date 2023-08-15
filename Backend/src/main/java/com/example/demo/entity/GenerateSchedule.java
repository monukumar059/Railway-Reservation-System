package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "train_schedule2")

public class GenerateSchedule {
	@Id
    @Column(name = "id")
	private int id;
	@Column(name="train_number")
	private int trainNumber;
	@Column(name="route_number")
	private int routeNumber;
	@Column(name="station_name")
	private String stationName;
	@Column(name="arrival_time")
	private String arrivalTime;
	@Column(name="departure_time")
	private String departureTime;
	
	
	public GenerateSchedule() {
		super();
	}
	public GenerateSchedule(int id, int trainNumber, int routeNumber, String stationName, String arrivalTime,
			String departureTime) {
		super();
		this.id = id;
		this.trainNumber = trainNumber;
		this.routeNumber = routeNumber;
		this.stationName = stationName;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}
	public int getRouteNumber() {
		return routeNumber;
	}
	public void setRouteNumber(int routeNumber) {
		this.routeNumber = routeNumber;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	
	
	
}
