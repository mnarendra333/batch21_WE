package com.pragim.SpringDIWthPremetive;

public class HelloWorldBean {
	
	private String message;
	
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public void showMesage(){
		System.out.println("Message is "+message);
	}
	
	
	

}
