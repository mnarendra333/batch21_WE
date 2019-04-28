package com.pragim.springcrud.dao;

import java.util.List;

import com.praim.springcrud.model.Flight;

public interface FlghtDao {
	
	public List<Flight> getAllFligts();
	
	public String addFlight(Flight flight);
	
	public String updateFlight(Flight flight);
	
	public String deleteFlight(int id);
	
	public Flight getFlightInfoById(int id);

}
