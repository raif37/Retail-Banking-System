package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dao.*;
import com.service.*;
import com.bean.*;

/**
 * Servlet implementation class AddNewCustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if(action.equals("viewallcustomerstatus")){
			CustomerService service=new CustomerService();
			ArrayList<CustomerStatusf> list=service.viewAllStatus();
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("viewAllCustomerStatus.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();
            
		String action = request.getParameter("action");
		if(action.equals("add"))
		{ 
			int SSN=Integer.parseInt(request.getParameter("SSN"));
			String CustomerName=request.getParameter("CustomerName");
			int age=Integer.parseInt(request.getParameter("age"));
			String AddressLine1=request.getParameter("address1");
			String AddressLine2 =request.getParameter("address2");
			String	City=request.getParameter("city");
			String  State=request.getParameter("state");
		
			Customerf cust=new  Customerf(SSN,CustomerName,age,AddressLine1,AddressLine2,City,State);
			
			System.out.println(cust);
			int result=0;
			result = new CustomerService().addCustomer(cust);
			if(result>=1)
			{
				out.println("<body style='background-color:#67aded;'>");
				out.write("<center><a type='button' href='cae.jsp' color='blue'>Redirect</a></center>");
				out.println("Customer creation initiated successfully");
				
			}
			else {
				out.println("<body style='background-color:#67aded;'>");
				out.write("<center><a type='button' href='cae.jsp' color='blue'>Redirect</a></center>");
				out.println("Customer creation failed !!");
			}
		}
		else if(action.equals("search")){
			
			try {
				String value=request.getParameter("value");
				if(value.equalsIgnoreCase("customerID")){

					int id=Integer.parseInt(request.getParameter("searchval"));					
					CustomerStatusf cust = new CustomerStatusf();
					cust = new CustomerDao().searchCustomer(id);					
					if(cust!=null && cust.getName()!=null)
					{
						request.setAttribute("id", cust.getCustomerid());
						request.setAttribute("ssn", cust.getSsnid());
						request.setAttribute("name", cust.getName());
						request.setAttribute("age", cust.getAge());
						request.setAttribute("add1", cust.getAddress1());
						request.setAttribute("add2", cust.getAddress2());
						request.setAttribute("city", cust.getCity());
						request.setAttribute("state", cust.getState());
						request.setAttribute("status", cust.getStatus());
						request.setAttribute("message", cust.getMessage());
						request.setAttribute("last_updated", cust.getLastUpdated());
						request.getRequestDispatcher("UpdateCustomer.jsp").forward(request, response);
					}
					else
					{
						out.println("<body style='background-color:#67aded;'>");
						out.write("<center><a type='button' href='SearchCustomer.jsp' color='blue'>Redirect</a></center>");
						out.println("Wrong customerID...Enter again..");
					}
				}
				else{
					
					int id=Integer.parseInt(request.getParameter("searchval"));					
					CustomerStatusf cust = new CustomerStatusf();
					cust = new CustomerDao().searchCustomerSSN(id);					
					if(cust!=null && cust.getName()!=null)
					{
						request.setAttribute("id", cust.getCustomerid());
						request.setAttribute("ssn", cust.getSsnid());
						request.setAttribute("name", cust.getName());
						request.setAttribute("age", cust.getAge());
						request.setAttribute("add1", cust.getAddress1());
						request.setAttribute("add2", cust.getAddress2());
						request.setAttribute("city", cust.getCity());
						request.setAttribute("state", cust.getState());
						request.setAttribute("status", cust.getStatus());
						request.setAttribute("message", cust.getMessage());
						request.setAttribute("last_updated", cust.getLastUpdated());
						request.getRequestDispatcher("UpdateCustomer.jsp").forward(request, response);
					}
					else
					{
						out.println("<body style='background-color:#67aded;'>");
						out.write("<center><a type='button' href='SearchCustomer.jsp' color='blue'>Redirect</a></center>");
						out.println("Wrong SSN ID...Enter again..");
					}
				}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
		else if(action.equals("update"))
		{ 
			try {
				int customerID = Integer.parseInt(request.getParameter("customerID"));			
				int SSN=Integer.parseInt(request.getParameter("SSN"));			
				String CustomerName=request.getParameter("CustomerName");
				int age=Integer.parseInt(request.getParameter("age"));
				String AddressLine1=request.getParameter("address1");
				String AddressLine2 =request.getParameter("address2");
				String	City=request.getParameter("city");
				String  State=request.getParameter("state");
				String status = request.getParameter("status");
				String message = request.getParameter("message");
				CustomerStatusf cust=new  CustomerStatusf(customerID,SSN,CustomerName,age,AddressLine1,AddressLine2,City,State,status,message);		
				int result=0;
				result = new CustomerDao().UpdateCustomer(cust);
				if(result>=1)
			    {
					out.println("<body style='background-color:#67aded;'>");
					out.write("<center><a type='button' href='cae.jsp' color='blue'>Redirect</a></center>");
					out.println("Customer update initiated successfully");
				}
				else
				{
					out.println("<body style='background-color:#67aded;'>");
					out.write("<center><a type='button' href='cae.jsp' color='blue'>Redirect</a></center>");
					out.println("Error occurred in updating");
				
			    }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(action.equals("search_cus")){

			
		
			
			try {
					String value=request.getParameter("value");
					if(value.equalsIgnoreCase("customerID")){

						int id=Integer.parseInt(request.getParameter("searchval"));					
						CustomerStatusf cust = new CustomerStatusf();
						cust = new CustomerDao().searchCustomer(id);					
						if(cust!=null && cust.getName()!=null)
						{
							request.setAttribute("id", cust.getCustomerid());
							request.setAttribute("ssn", cust.getSsnid());
							request.setAttribute("name", cust.getName());
							request.setAttribute("age", cust.getAge());
							request.setAttribute("add1", cust.getAddress1());
							request.setAttribute("add2", cust.getAddress2());
							request.setAttribute("city", cust.getCity());
							request.setAttribute("state", cust.getState());
							request.setAttribute("status", cust.getStatus());
							request.setAttribute("message", cust.getMessage());
							request.setAttribute("last_updated", cust.getLastUpdated());
							System.out.println(cust.getLastUpdated());
							request.getRequestDispatcher("DisplayCustomer.jsp").forward(request, response);
						}
						else
						{
							out.println("<body style='background-color:#67aded;'>");
							out.write("<center><a type='button' href='SearchSpecificCustomer.jsp' color='blue'>Redirect</a></center>");
							out.println("Wrong Customer ID...Enter again..");
						}
					}
					else{
						
						int id=Integer.parseInt(request.getParameter("searchval"));					
						CustomerStatusf cust = new CustomerStatusf();
						cust = new CustomerDao().searchCustomerSSN(id);					
						if(cust!=null && cust.getName()!=null)
						{
							request.setAttribute("id", cust.getCustomerid());
							request.setAttribute("ssn", cust.getSsnid());
							request.setAttribute("name", cust.getName());
							request.setAttribute("age", cust.getAge());
							request.setAttribute("add1", cust.getAddress1());
							request.setAttribute("add2", cust.getAddress2());
							request.setAttribute("city", cust.getCity());
							request.setAttribute("state", cust.getState());
							request.setAttribute("status", cust.getStatus());
							request.setAttribute("message", cust.getMessage());
							request.setAttribute("last_updated", cust.getLastUpdated());
							request.getRequestDispatcher("DisplayCustomer.jsp").forward(request, response);
						}
						else
						{
							out.println("<body style='background-color:#67aded;'>");
							out.write("<center><a type='button' href='SearchSpecificCustomer.jsp' color='blue'>Redirect</a></center>");
							out.println("Wrong SSN ID...Enter again..");
						}
					}
					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(action.equals("delete"))
		{
	
			int CustId=Integer.parseInt(request.getParameter("CustId"));
			CustomerService service = new CustomerService();
			int rowsDeleted = service.deleteCustomer(CustId);
			if (rowsDeleted > 0) {
				out.println("<body style='background-color:#67aded;'>");
				out.write("<center><a type='button' href='cae.jsp' color='blue'>Redirect</a></center>");
			   out.println("Customer deletion initiated successfully.");
			}
			else {
				out.println("<body style='background-color:#67aded;'>");
				out.write("<center><a type='button' href='deleteCustomer.jsp' color='blue'>Redirect</a></center>");
				out.println("Error occured");
			}
		}
	
	}

}
