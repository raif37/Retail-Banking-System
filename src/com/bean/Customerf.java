package com.bean;

public class Customerf {
	
	private int ssnid;
	private int customerid;
	private String name;
	private int age;
	private String address1;
	private String address2;
	private String city;
	private String state;

public Customerf(int ssnid, String name, int age, String address1,
			String address2, String city, String state) {
		super();
		this.ssnid = ssnid;
		this.name = name;
		this.age = age;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
	}

public Customerf( int customerid,int ssnid, String name, int age,
		String address1, String address2, String city, String state) {
	super();
	this.ssnid = ssnid;
	this.customerid = customerid;
	this.name = name;
	this.age = age;
	this.address1 = address1;
	this.address2 = address2;
	this.city = city;
	this.state = state;
}
public Customerf() {
	super();
	// TODO Auto-generated constructor stub
}

public Customerf(int ssn, int id) {
	// TODO Auto-generated constructor stub
	ssnid=ssn;
	customerid=id;
}

public int getSsnid() {
	return ssnid;
}

public void setSsnid(int ssnid) {
	this.ssnid = ssnid;
}

public int getCustomerid() {
	return customerid;
}

public void setCustomerid(int customerid) {
	this.customerid = customerid;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getAddress1() {
	return address1;
}

public void setAddress1(String address1) {
	this.address1 = address1;
}

public String getAddress2() {
	return address2;
}

public void setAddress2(String address2) {
	this.address2 = address2;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

@Override
public String toString() {
	return "Customerf [ssnid=" + ssnid + ", customerid=" + customerid + ", name=" + name + ", age=" + age
			+ ", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", state=" + state + "]";
}

}

