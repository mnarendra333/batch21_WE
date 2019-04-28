package com.pragim.springcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pragim.springcrud.bean.FlightBean;
import com.pragim.springcrud.dao.FlghtDao;
import com.pragim.springcrud.util.FlightUtilty;
import com.praim.springcrud.model.Flight;

@Controller
public class FlightController {
	
	@Autowired
	private FlghtDao dao;
	
	
	
	@RequestMapping("/")
	public String getAllFligts(Model model){
		List<Flight> allFligts = dao.getAllFligts();
		//List<FlightBean> allFligtsBeans = new ArrayList<FlightBean>();
		
		/*for (Flight flight : allFligts) {
			FlightBean obj = new FlightBean();
			obj.setId(flight.getId());
			obj.setFlightId(flight.getFlightId());
			obj.setFlightName(flight.getFlightName());
			obj.setDepartureTime(flight.getDepartureTime());
			obj.setCost(flight.getCost());
			allFligtsBeans.add(obj);
		}*/
		model.addAttribute("list", allFligts);
		model.addAttribute("flightform", new Flight());
		
		return  "flightList";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addFlight(@ModelAttribute(name="flightform") FlightBean obj){
		FlightUtilty util = new FlightUtilty();
		Flight flight = util.populateBeanIntoModel(obj);
		
		if(obj.getFlightName()!=null){
			dao.updateFlight(flight);
		}
		else{
			String message = dao.addFlight(flight);
		}
		
		
		return "redirect:/";
	}
	
	/*@RequestMapping("/update")
	public ModelAndView updateFlight(){
		dao.updateFlight(flight)
		return null;
	}*/
	
	@RequestMapping("/fetchbyid")
	public String getFlightInfoById(@RequestParam("id") String fId,Model model){
		Flight flightInfoById = dao.getFlightInfoById(Integer.parseInt(fId));
		model.addAttribute("flightform", flightInfoById);
		List<Flight> allFligts = dao.getAllFligts();
		model.addAttribute("list", allFligts);
		
		return  "flightList";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String deleteFlight(@PathVariable("id") String fId){
		String deleteFlight = dao.deleteFlight(Integer.parseInt(fId));
		return "redirect:/";
	}

}
