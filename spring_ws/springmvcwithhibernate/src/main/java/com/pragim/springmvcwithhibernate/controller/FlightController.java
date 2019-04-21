package com.pragim.springmvcwithhibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pragim.springmvcwithhibernate.dao.FlightDao;
import com.pragim.springmvcwithhibernate.model.Flight;

@Controller
public class FlightController {

	@Autowired
	private FlightDao dao;
	
	public void setDao(FlightDao dao) {
		this.dao = dao;
	}

	

	@RequestMapping("/list")
	public ModelAndView getFlightList() {
		List<Flight> flightList = dao.getFlightList();
		return new ModelAndView("flightList", "list", flightList);
	}

	@RequestMapping("/welcome")
	public ModelAndView hello() {
		return new ModelAndView("index", "mes", "welcome to spring mvc");
	}

}
