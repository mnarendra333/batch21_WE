package com.pragim.springcrud.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.praim.springcrud.model.Flight;

@Repository
@Transactional
public class FlightDaoImpl implements FlghtDao {
	
	@Autowired
	private SessionFactory factory;
	
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public List<Flight> getAllFligts() {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("select f from Flight f");
		return query.list();
	}

	@Override
	public String addFlight(Flight flight) {
		Session session = factory.openSession();
		session.save(flight);
		session.beginTransaction().commit();
		return "Flight added successfully";
	}

	@Override
	public String updateFlight(Flight flight) {
		Session session = factory.openSession();
		session.save(flight);
		session.beginTransaction().commit();
		return "Flight updated successfully";
	}

	@Override
	
	public String deleteFlight(int id) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		int executeUpdate = session.createQuery("delete from Flight f where f.id=:flightId").setParameter("flightId", id).executeUpdate();
		return "Flight deleted successfully";
	}

	@Override
	public Flight getFlightInfoById(int id) {
		Session session = factory.getCurrentSession();
		Flight load = session.get(Flight.class, id);
		return load;
	}

}
