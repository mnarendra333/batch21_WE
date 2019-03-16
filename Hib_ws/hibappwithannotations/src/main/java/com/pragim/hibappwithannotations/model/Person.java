package com.pragim.hibappwithannotations.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="per_tab")
public class Person {

	@Override
	public String toString() {
		return "Person [perId=" + perId + ", perName=" + perName + ", addr="
				+ addr + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="per003_seq")
	@SequenceGenerator(name="per003_seq",sequenceName="per003_seq",allocationSize=1)
	@Column(name="p_id")
	private int perId;
	
	@Column(name="p_name",length=30)
	private String perName;
	
	@Column(length=30)
	private String addr;

	public int getPerId() {
		return perId;
	}

	public void setPerId(int perId) {
		this.perId = perId;
	}

	public String getPerName() {
		return perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}
