package com.pragim.SpringDIWithObjectsUsingConstructor;

public class Car implements Vehicle {

	private String model;
	private String color;

	public Car(String model, String color) {
		super();
		this.model = model;
		this.color = color;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("Car model is "+this.model+" and car color is "+this.color);
		System.out.println("going by Car!!");
	}

}
