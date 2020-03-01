package com.carminiproject.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="cars")
public class Cars implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CAR_ID")
	private int carId;
	
	@Column(name="YEAR")
	private int year;
	
	@Column(name="MAKE")
	private String make;
	
	@Column(name="MODEL")
	private String model;
	
	
	
	public Cars() {
		
	}
	
	public Cars(int year, String make, String model) {
		super();
		this.year = year;
		this.make = make;
		this.model = model;
	}
	

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Cars [carId=" + carId + ", year=" + year + ", make=" + make + ", model=" + model + "]";
	}
	
	
	
}
