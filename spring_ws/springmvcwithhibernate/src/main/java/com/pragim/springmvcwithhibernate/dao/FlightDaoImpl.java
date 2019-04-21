package com.pragim.springmvcwithhibernate.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;



import com.pragim.springmvcwithhibernate.model.Flight;

public class FlightDaoImpl implements FlightDao {

	@Autowired
	private SessionFactory factory;

	/*public FlightDaoImpl(SessionFactory factory) {
		super();
		this.factory = factory;
	}*/

	@Override
	public List<Flight> getFlightList() {
		Session openSession = factory.openSession();
		return openSession.createQuery("from Flight f").list();
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

}
