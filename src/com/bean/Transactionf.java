package com.bean;

import java.sql.Timestamp;

public class Transactionf {
	
	private String transactionId;
	private int accountId;
	private double amount;
	private String type;
	private String message;
	private Timestamp transactionDate;
	public Transactionf(String transactionId, int accountId, double amount, String type, String message,
			Timestamp transactionDate) {
		super();
		this.transactionId = transactionId;
		this.accountId = accountId;
		this.amount = amount;
		this.type = type;
		this.message = message;
		this.transactionDate = transactionDate;
	}
	public Transactionf(String id, int acctId, Timestamp date, String description, String type2, double balance) {
		// TODO Auto-generated constructor stub
		
		this.transactionId = id;
		this.accountId = acctId;
		this.amount = balance;
		this.type = type2;
		this.message = description;
		this.transactionDate = date;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	
	
	

}
