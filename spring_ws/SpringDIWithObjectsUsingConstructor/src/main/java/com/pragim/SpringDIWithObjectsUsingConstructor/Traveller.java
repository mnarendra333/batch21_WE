package com.pragim.SpringDIWithObjectsUsingConstructor;

public class Traveller {
	
	
	private Vehicle vehicle;

	/*public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}*/
	
	
	public Traveller(Vehicle vehicle){
		this.vehicle = vehicle;
	}
	
	
	
	public void planTravel(){
	
		vehicle.start();
		
	}
	
	
	
	

}
