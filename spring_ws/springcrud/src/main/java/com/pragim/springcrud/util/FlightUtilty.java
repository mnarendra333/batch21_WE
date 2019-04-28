package com.pragim.springcrud.util;

import com.pragim.springcrud.bean.FlightBean;
import com.praim.springcrud.model.Flight;

public class FlightUtilty {
	
	
	public Flight populateBeanIntoModel(FlightBean bean){
		
		Flight flight = new Flight();
		
		if(bean.getFlightId()!=null){
			flight.setFlightId(bean.getFlightId());
		}
		
		if(bean.getFlightName()!=null){
			flight.setFlightName(bean.getFlightName());
		}
		
		if(bean.getDepartureTime()!=null){
			flight.setDepartureTime(bean.getDepartureTime());
		}
		
		if(bean.getCost()!=null){
			flight.setCost(bean.getCost());
		}
		return flight;
	}

}
