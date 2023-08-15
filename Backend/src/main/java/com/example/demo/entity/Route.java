package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "route_details")
public class Route {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
	
	@Column(name = "station_name")
	private String station_name;
	
	@Column(name = "station_code")
	private String station_code;
	
	@Column(name = "route_order")
	private int route_order;
	
	@Column(name = "distance")
	private float distance;
	
	@Column(name = "route_name")
	private String route_name;
	@Column(name = "route_number")
	private int route_number;




	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStation_name() {
		return station_name;
	}

	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}

	public String getStation_code() {
		return station_code;
	}

	public void setStation_code(String station_code) {
		this.station_code = station_code;
	}

	public Integer getRoute_order() {
		return route_order;
	}

	public void setRoute_order(Integer route_order) {
		this.route_order = route_order;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public String getRoute_name() {
		return route_name;
	}

	public void setRout_name(String route_name) {
		this.route_name = route_name;
	}

	public int getRoute_number() {
		return route_number;
	}

	public void setRoute_number(int route_number) {
		this.route_number = route_number;
	}
	
	
	
	
}
