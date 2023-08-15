package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "passenger_details")
public class PassDetails {

	@Id
    @Column(name = "passenger_id")
	private int passenger_id;
	
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "age")
	private int age;
	@Column(name = "gender")
	private String gender;
	@Column(name = "mobile_no")
	private double  mobileNo;
	@Column(name = "email")
	private String email;
	@Column(name = "pnr_no")
	private long  pnrNo;
	
	public PassDetails() {
		super();
	}
	
	

	public PassDetails(int passengerId, String firstName, String lastName, int age, String gender, double mobileNo,
			String email, long pnrNo) {
		super();
		this.passenger_id = passengerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.email = email;
		this.pnrNo = pnrNo;
	}



	/**
	 * @return the passenger_id
	 */
	public int getPassenger_id() {
		return passenger_id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @return the mobileNo
	 */
	public double getMobileNo() {
		return mobileNo;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the pnrNo
	 */
	public long getPnrNo() {
		return pnrNo;
	}
	

}