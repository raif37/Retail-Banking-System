package com.bean;

public class Accountf {
	
		private int accountid;
		private int customerid;
		private int ssnid;
		private String accounttype;
		private double balance;
		
public Accountf() {
			super();
			// TODO Auto-generated constructor stub
  }

public Accountf(int accountid, String accounttype) {
	super();
	this.accountid = accountid;
	this.accounttype = accounttype;
}

public Accountf(int customerid, String accounttype, double balance) {
	super();
	this.customerid = customerid;
	this.accounttype = accounttype;
	this.balance = balance;
}

public Accountf(int accountid, int customerid, String accounttype,
		double balance) {
	super();
	this.accountid = accountid;
	this.customerid = customerid;
	this.accounttype = accounttype;
	this.balance = balance;
}

public Accountf(int customerid,int accountid,  String accounttype) {
	super();
	this.customerid = customerid;
	this.accountid = accountid;
	this.accounttype = accounttype;
}

public int getAccountid() {
	return accountid;
}

public void setAccountid(int accountid) {
	this.accountid = accountid;
}

public int getCustomerid() {
	return customerid;
}

public void setCustomerid(int customerid) {
	this.customerid = customerid;
}

public int getSsnid() {
	return ssnid;
}

public void setSsnid(int ssnid) {
	this.ssnid = ssnid;
}

public String getAccounttype() {
	return accounttype;
}

public void setAccounttype(String accounttype) {
	this.accounttype = accounttype;
}

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}




		
		
}
