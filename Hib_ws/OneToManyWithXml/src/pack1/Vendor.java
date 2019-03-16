package pack1;

import java.util.Set;

public class Vendor {

	private int venId;
	private String venName;

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
