package com.pragim.springmvcwithhibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flights")
public class Flight {
	
	@Id
	private int id;
	
	@Column(name="flight_id", length=30)
	private int flightId;
	
	@Column(name="flight_name", length=30)
	private String flightName;
	
	@Column(name="FLIGHT_TIME_DEP")
	private Date departureTime;
	
	@Column(name="FLIGHT_FARE")
	private double cost;

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
