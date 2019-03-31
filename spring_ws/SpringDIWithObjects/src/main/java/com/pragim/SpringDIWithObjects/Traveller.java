package com.pragim.SpringDIWithObjects;

public class Traveller {
	
	
	private Vehicle vehicle;

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	
	public void planTravel(){
	
		vehicle.start();
		
	}
	
	
	
	

}
