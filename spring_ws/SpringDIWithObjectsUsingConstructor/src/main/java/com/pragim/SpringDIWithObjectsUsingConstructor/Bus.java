package com.pragim.SpringDIWithObjectsUsingConstructor;

public class Bus implements Vehicle {
	
	private String model;
	private String color;
	
	public Bus(String model, String color) {
		super();
		this.model = model;
		this.color = color;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("Bus model is "+this.model+" and Bus color is "+this.color);
		System.out.println("Going by Bus!!");

	}

}
