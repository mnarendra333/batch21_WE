package com.pragim.model;

public class Players {

	// ply_id number(10) primary key,ply_name varchar2(20),age number(10),now
	// number(10),skill varchar2(20),rank number(10),tid number(10)
	private int plyId;
	private String plyName;
	private int age;
	private int now;
	private String skill;
	private int rank;
	public Players(int plyId, String plyName, int age, int now, String skill,
			int rank) {
		super();
		this.plyId = plyId;
		this.plyName = plyName;
		this.age = age;
		this.now = now;
		this.skill = skill;
		this.rank = rank;
	}
	public int getPlyId() {
		return plyId;
	}
	public String getPlyName() {
		return plyName;
	}
	public int getAge() {
		return age;
	}
	public int getNow() {
		return now;
	}
	public String getSkill() {
		return skill;
	}
	public int getRank() {
		return rank;
	}
	
	
	
	
	
	

}
