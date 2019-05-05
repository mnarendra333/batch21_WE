package com.pragim.springrestwithhibjavaconfig.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User_data")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="username",length=30)
	private String name;
	
	@Column(name="address",length=30)
	private String addr;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}
