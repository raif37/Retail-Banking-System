package com.bean;

public class Employeef {
	private String employee_id;
	private String password;
	private String employee_type;
	
	
	public Employeef(String employee_id, String password, String employee_type) {
		super();
		this.employee_id = employee_id;
		this.password = password;
		this.employee_type = employee_type;
	}
	
	
	public Employeef(String employee_id, String password) {
		super();
		this.employee_id = employee_id;
		this.password = password;
	}
	
	
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmployee_type() {
		return employee_type;
	}
	public void setEmployee_type(String employee_type) {
		this.employee_type = employee_type;
	}
	
	

}
