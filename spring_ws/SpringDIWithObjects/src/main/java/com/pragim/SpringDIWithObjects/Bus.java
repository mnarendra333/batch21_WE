package com.pragim.SpringDIWithObjects;

public class Bus implements Vehicle {
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
		// TODO Auto-generated method stub
		System.out.println("model is "+model+" color is "+color);
		System.out.println("Going by Bus!!");

	}

}
