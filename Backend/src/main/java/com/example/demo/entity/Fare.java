package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "fare_details")
public class Fare {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fare_id")
	private long id;
	
	@Column(name = "train_type")
	private String trainType;
	
	@Column(name = "coach_type")
	private String coachType;
	
	@Column(name = "fare")
	private double fare;

	public Fare() {
		super();
	}
	

	public Fare(long id, String trainType, String coachType, double fare) {
		super();
		this.id = id;
		this.trainType = trainType;
		this.coachType = coachType;
		this.fare = fare;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTrain_type() {
		return trainType;
	}

	public void setTrain_type(String trainType) {
		this.trainType = trainType;
	}

	public String getCoach_type() {
		return coachType;
	}

	public void setCoach_type(String coachType) {
		this.coachType = coachType;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(long fare) {
		this.fare = fare;
	}
	
	
	
}
