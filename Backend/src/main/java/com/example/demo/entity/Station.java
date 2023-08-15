package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "station_details")
public class Station {

	@Id
	@Column(name = "station_code")
	private String id;
	@Column(name = "station_name")
	private String Station_name;
	@Column(name = "station_city")
	private String Station_city;
	@Column(name = "station_state")
	private String Station_state;

	public Station(String id, String station_name, String station_city, String station_state) {
		super();
		this.id = id;
		Station_name = station_name;
		Station_city = station_city;
		Station_state = station_state;
	}

	public Station() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStation_name() {
		return Station_name;
	}

	public void setStation_name(String station_name) {
		Station_name = station_name;
	}

	public String getStation_city() {
		return Station_city;
	}

	public void setStation_city(String station_city) {
		Station_city = station_city;
	}

	public String getStation_state() {
		return Station_state;
	}

	public void setStation_state(String station_state) {
		Station_state = station_state;
	}

}
