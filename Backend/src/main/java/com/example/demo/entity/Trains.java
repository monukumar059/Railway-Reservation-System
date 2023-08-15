package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "train_details")
public class Trains {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "train_number")
	private long train_number;
	
	@Column(name = "train_name")
	private String train_name;
	
	@Column(name = "a2_coach")
	private int a2_coach;
	
	
	@Column(name = "a3_coach")
	private int a3_coach;
	
	@Column(name = "train_type")
	private String train_type;
	
	@Column(name = "average_speed")
	private long average_speed;
	
	@Column(name = "total_2a_Seats")
	private int total_2A_Seats;
	
	@Column(name = "total_3a_Seats")
	private int total_3A_Seats;

	public Trains() {
		super();
	}

	public Trains(long train_number, String train_name, int a2_coach, int a3_coach, String train_type,
			long average_speed, int total_2A_Seats, int total_3A_Seats) {
		super();
		this.train_number = train_number;
		this.train_name = train_name;
		this.a2_coach = a2_coach;
		this.a3_coach = a3_coach;
		this.train_type = train_type;
		this.average_speed = average_speed;
		this.total_2A_Seats = total_2A_Seats;
		this.total_3A_Seats = total_3A_Seats;
	}

	public long getTrain_number() {
		return train_number;
	}

	public void setTrain_number(long train_number) {
		this.train_number = train_number;
	}

	public String getTrain_name() {
		return train_name;
	}

	public void setTrain_name(String train_name) {
		this.train_name = train_name;
	}

	public int getA2_coach() {
		return a2_coach;
	}

	public void setA2_coach(int a2_coach) {
		this.a2_coach = a2_coach;
	}

	public int getA3_coach() {
		return a3_coach;
	}

	public void setA3_coach(int a3_coach) {
		this.a3_coach = a3_coach;
	}

	public String getTrain_type() {
		return train_type;
	}

	public void setTrain_type(String train_type) {
		this.train_type = train_type;
	}

	public long getAverage_speed() {
		return average_speed;
	}

	public void setAverage_speed(long average_speed) {
		this.average_speed = average_speed;
	}

	public int getTotal_2A_Seats() {
		return total_2A_Seats;
	}

	public void setTotal_2A_Seats(int total_2A_Seats) {
		this.total_2A_Seats = total_2A_Seats;
	}

	public int getTotal_3A_Seats() {
		return total_3A_Seats;
	}

	public void setTotal_3A_Seats(int total_3A_Seats) {
		this.total_3A_Seats = total_3A_Seats;
	}
	
	
}
