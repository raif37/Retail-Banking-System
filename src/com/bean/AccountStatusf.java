package com.bean;

import java.sql.Timestamp;

public class AccountStatusf extends Accountf{
	
	private String status;
	private String message;
	private Timestamp lastUpdated;
	
public AccountStatusf(int customerid,int accountid,String accounttype,String status, String message, Timestamp lastUpdated) {
		super(customerid,accountid,accounttype);
		this.status = status;
		this.message = message;
		this.lastUpdated = lastUpdated;
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
