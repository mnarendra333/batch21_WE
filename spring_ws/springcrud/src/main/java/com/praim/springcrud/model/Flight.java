package com.praim.springcrud.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="flights")
public class Flight {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="flight_seq")
	@SequenceGenerator(name="flight_seq",sequenceName="flight_seq",allocationSize=1)
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightId=" + flightId + ", flightName="
				+ flightName + ", departureTime=" + departureTime + ", cost="
				+ cost + "]";
	}

	@Column(name="flight_id", length=30)
	private Integer flightId;
	
	@Column(name="flight_name", length=30)
	private String flightName;
	
	@Column(name="FLIGHT_TIME_DEP")
	private Date departureTime;
	
	@Column(name="FLIGHT_FARE")
	private Double cost;

	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
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

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}


}
