package com.example.demo.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking_details")
public class BookingDetails {

	@Id
	@Column(name = "pnr_number")
	private long id;
	@Column(name = "source_station")
	private String sourceStation;
	@Column(name = "destination_station")
	private String destinationStation;
	@Column(name = "train_number")
	private int trainNumber;
	@Column(name = "travel_date")
	private Date travelDate;
	@Column(name = "class")
	private String class1;
	@Column(name = "passenger_no")
	private int passengerNo;
	@Column(name = "booking_status")
	private String BookingStatus;
	@Column(name = "user_id")
	private String UserId;
	@Column(name = "fare")
	private double fare;
	
	
	public BookingDetails() {
		super();
	}


	public BookingDetails(long id, String sourceStation, String destinationStation, int trainNumber,
			Date travelDate, String class1, int passengerNo, String BookingStatus, String UserId, double fare) {
		super();
		this.id = id;
		this.sourceStation = sourceStation;
		this.destinationStation = destinationStation;
		this.trainNumber = trainNumber;
		this.travelDate = travelDate;
		this.class1 = class1;
		this.passengerNo = passengerNo;
		this.BookingStatus = BookingStatus;
		this.UserId = UserId;
		this.fare = fare;
	}


	public long getId() {
		return id;
	}

	public String getSource_station() {
		return sourceStation;
	}

	public String getDestination_station() {
		return destinationStation;
	}

	public int getTrain_number() {
		return trainNumber;
	}


	public Date getTravel_date() {
		return travelDate;
	}

	public String getClass1() {
		return class1;
	}


	public int getPassenger_no() {
		return passengerNo;
	}


	public String getBooking_status() {
		return BookingStatus;
	}


	
	public String getUser_id() {
		return UserId;
	}


	
	public double getFare() {
		return fare;
	}
	

}
