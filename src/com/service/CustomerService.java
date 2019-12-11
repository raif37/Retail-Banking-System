package com.service;

import java.util.ArrayList;

import com.bean.*;
import com.dao.*;

public class CustomerService {

	public int addCustomer(Customerf cust){
		CustomerDao dao=new CustomerDao();
		int result=dao.addNewCustomer(cust);
		return result;
	}
	
	public ArrayList<CustomerStatusf> viewAllStatus(){
		CustomerDao dao=new CustomerDao();
		return dao.viewAllStatus();
	}
	public int deleteCustomer(int custID){
		
		CustomerDao dao = new CustomerDao();
		return dao.deleteCustomer(custID);
		
	}
	
	
	
}
