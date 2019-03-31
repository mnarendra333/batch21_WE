package com.pragim.SpringAWWithAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Person {
	
	
	private Computer computer;
	
	
	public Person(Computer computer) {
		super();
		this.computer = computer;
	}

	@Autowired
	public void setComputer(Computer computer){
		this.computer = computer;
	}
	public void doWork(){
		computer.operate();
	}

}
