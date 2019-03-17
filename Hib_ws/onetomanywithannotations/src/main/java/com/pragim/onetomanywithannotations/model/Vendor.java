package com.pragim.onetomanywithannotations.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table
public class Vendor {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="vendor_seq")
	@SequenceGenerator(name="vendor_seq",sequenceName="vendor_seq",allocationSize=1)
	private int venId;
	private String venName;

	
	@OneToMany(targetEntity=Customer.class,orphanRemoval=true)
	@JoinColumn(name="ven_id")
	private Set<Customer> custList;

	public int getVenId() {
		return venId;
	}

	public void setVenId(int venId) {
		this.venId = venId;
	}

	public String getVenName() {
		return venName;
	}

	public void setVenName(String venName) {
		this.venName = venName;
	}

	public Set<Customer> getCustList() {
		return custList;
	}

	public void setCustList(Set<Customer> custList) {
		this.custList = custList;
	}

}
