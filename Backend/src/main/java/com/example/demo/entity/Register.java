package com.example.demo.entity;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "register")
public class Register {
	
	
	@Id
    @Column(name = "user_id")
	private String user_id;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "confirm_password")
	private String confirmPassword;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "mobile_no")
	private long mobile_no;
	
	@Column(name = "aadhar_no")
	private long aadharNo;
	
	@Column(name = "street_line")
	private String streetLine;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "pin_code")
	private Integer pinCode;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "nationality")
	private String nationality;

	public Register() {
		super();
	}

	public Register(String userId, String password, String confirmPassword, String fullName, String gender,
			LocalDate dateOfBirth, String email, long mobileNo, long aadharNo, String streetLine, String city,
			Integer pinCode, String country, String nationality) {
		super();
		this.user_id = userId;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.fullName = fullName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.mobile_no = mobileNo;
		this.aadharNo = aadharNo;
		this.streetLine = streetLine;
		this.city = city;
		this.pinCode = pinCode;
		this.country = country;
		this.nationality = nationality;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return user_id;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.user_id = userId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * @param confirmPassword the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileNo() {
		return mobile_no;
	}

	
	public void setMobileNo(long mobileNo) {
		this.mobile_no = mobileNo;
	}

	public long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getStreetLine() {
		return streetLine;
	}
	public void setStreetLine(String streetLine) {
		this.streetLine = streetLine;
	}

	public String getCity() {
		return city;
	}

	
	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	

}
