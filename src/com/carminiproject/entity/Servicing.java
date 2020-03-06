package com.carminiproject.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="servicing")
public class Servicing implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SERVICING_ID")
	private int servicingId;

	@Column(name="SERVICING_DATE")
	private LocalDate servicingDate;

	@Column(name="SERVICING_DESCRIPTION")
	private String servicingDesc;

	@Column(name="VEHICAL_MILEAGE")
	private int mileage;

	
	//@ManyToOne(cascade=CascadeType.PERSIST)
	//@JoinColumn(name="CAR_ID")
	@ManyToOne (cascade= {CascadeType.REFRESH} ,fetch = FetchType.LAZY)
	@JoinColumn(name="CAR_ID",referencedColumnName="CAR_ID")
	private Cars car;
	
	public Servicing() {

	}
	
	public Servicing(Cars car) {
		super();
		this.car = car;
		LocalDate todaysdate = LocalDate.now();
		setServicingDate(todaysdate);

	}

	public Servicing(Cars car , LocalDate servicingDate, String servicingDesc, int mileage) {
		super();
		this.car = car;
		this.servicingDate = servicingDate;
		this.servicingDesc = servicingDesc;
		this.mileage = mileage;
	}
	/*
	 * public Servicing(int mileage, LocalDate servicingDate, String servicingDesc,
	 * Cars car ) { super(); this.mileage = mileage; this.servicingDate =
	 * servicingDate; this.servicingDesc = servicingDesc; this.car = car;
	 * 
	 * }
	 */

	public int getServicingId() {
		return servicingId;
	}

	public void setServicingId(int servicingId) {
		this.servicingId = servicingId;
	}

	public LocalDate getServicingDate() {
		return servicingDate;
	}

	public void setServicingDate(LocalDate servicingDate) {
		this.servicingDate = servicingDate;
	}

	public String getServicingDesc() {
		return servicingDesc;
	}

	public void setServicingDesc(String servicingDesc) {
		this.servicingDesc = servicingDesc;
	}

	
	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public Cars getCar() {
		return car;
	}

	public void setCar(Cars car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Servicing [servicingId=" + servicingId + ", servicingDate=" + servicingDate + ", servicingDesc="
				+ servicingDesc + ", mileage=" + mileage + ", car=" + car + "]";
	}

	
}
