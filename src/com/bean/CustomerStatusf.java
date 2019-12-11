package com.bean;

import java.sql.Timestamp;

public class CustomerStatusf extends Customerf {

	
	private String status;
	private String message;
	private Timestamp lastUpdated;
	
	
	
	
	
	
	public CustomerStatusf() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerStatusf(int customerid, int ssnid, String name, int age, String address1, String address2,
			String city, String state, String status,String message) {
		super(customerid, ssnid, name, age, address1, address2, city, state);
		this.status = status;
	    this.message = message;
	}
	public CustomerStatusf(int customerid,int ssnid, String name, int age, String address1, String address2, String city,
			String state) {
		super(customerid,ssnid, name, age, address1, address2, city, state);
		// TODO Auto-generated constructor stub
	}
	
	public CustomerStatusf(int ssnid, String name, int age, String address1, String address2, String city,
			String state) {
		super(ssnid, name, age, address1, address2, city, state);
		// TODO Auto-generated constructor stub
	}
	
	
	public CustomerStatusf(int ssn, int id, String status2, String message2, Timestamp last_update) {
		// TODO Auto-generated constructor stub
		super(ssn,id);
		status=status2;
		message=message2;
		lastUpdated=last_update;
		
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

}
