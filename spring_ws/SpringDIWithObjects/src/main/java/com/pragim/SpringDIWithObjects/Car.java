package com.pragim.SpringDIWithObjects;

public class Car implements Vehicle {

	private String model;
	private String color;

	public void setModel(String model) {
		this.model = model;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void start() {
		System.out.println("model is "+model+" color is "+color);
		System.out.println("going by Car!!");
	}

}
