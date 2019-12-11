package com.controller;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.*;

import com.service.*;

import com.dao.*;


/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AccountServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if(action.equals("viewallaccountstatus")){
			AccountService service=new AccountService();
			ArrayList<AccountStatusf> list=service.viewAllStatus();
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("viewAllAccountStatus.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		AccountService service = new AccountService();

		if(action.equals("add")){
			int Customer_Id = Integer.parseInt(request.getParameter("custid"));
			String Account_Type = request.getParameter("acctype");
			double Deposit_Amount = Double.parseDouble(request.getParameter("depamt"));
			Accountf a = new Accountf(Customer_Id, Account_Type, Deposit_Amount);
			int result = service.insertAccount(a);
			if(result>=1){
				out.println("<body style='background-color:#67aded;'>");
				out.write("<center><a type='button' href='cae.jsp' color='blue'>Redirect</a></center>");
				out.println("Successfully Registered");
			}
			else{
				out.println("<body style='background-color:#67aded;'>");
			out.write("<center><a type='button' href='cae.jsp' color='blue'>Redirect</a></center>");
				out.println("Error occurred");
			}
		}
		else if(action.equals("delete")){

			int id = Integer.parseInt(request.getParameter("accid"));
			Accountf a = service.retrieveAccount(id);
			if(a!=null){
				
				request.setAttribute("acct", a);
				//System.out.println("inside it");
				RequestDispatcher rd=null;
				rd=request.getRequestDispatcher("deletedata.jsp");
				rd.forward(request, response);
			}
			else{
				out.println("<body style='background-color:#67aded;'>");
				out.write("<center><a type='button' href='cae.jsp' color='blue'>Redirect</a></center>");
				out.println("No details");
			}
		}
		
		else if(action.equals("view"))
		{
			  String IdType=request.getParameter("type");
		      int id = Integer.parseInt(request.getParameter("id"));
		      AccountDao accdao=new AccountDao();
		      ArrayList<Integer> idlist=new ArrayList<Integer>();
		      idlist=accdao.viewAccountId(id,IdType);
		      
		      request.setAttribute("idlist", idlist);
		      request.getRequestDispatcher("displayAccountInfo.jsp").forward(request, response);
		}
		else if(action.equals("acid"))
		{
				Accountf b;
				AccountDao accdao=new AccountDao();
				int unique_id = Integer.parseInt(request.getParameter("accountid"));
				b=accdao.viewAccount(unique_id);
				int custid=b.getCustomerid();
				int accid=b.getAccountid();
				String atype=b.getAccounttype();
				double bal=b.getBalance(); 
				request.setAttribute("custid", custid);
				request.setAttribute("accid",accid);
				request.setAttribute("atype",atype);
				request.setAttribute("bal", bal);
				request.getSession().setAttribute("account", b);
				request.getRequestDispatcher("viewAccountInfo.jsp").forward(request, response); 

		}
		
		else if(action.equals("accid"))
		{
			//System.out.println("i am in a aid");

			Accountf b=new Accountf();
			AccountDao accdao=new AccountDao();
		      int aid = Integer.parseInt(request.getParameter("aid"));
		         b=accdao.viewAccount(aid);
              int custid=b.getCustomerid();
              int accid=b.getAccountid();
              String atype=b.getAccounttype();
              double bal=b.getBalance(); 
              request.setAttribute("custid", custid);
              request.setAttribute("accid",accid);
              request.setAttribute("atype",atype);
              request.setAttribute("bal", bal);
              request.getSession().setAttribute("account", b);
              request.getRequestDispatcher("viewAccountInfo.jsp").forward(request, response); 

		}
		else if(action.equals("viewaccounttable"))
		{
			  String IdType=request.getParameter("type");
		      int id = Integer.parseInt(request.getParameter("id"));
		      AccountDao accdao=new AccountDao();
		      ArrayList<Accountf> idlist;
		      idlist=accdao.viewAccountIdTable(id,IdType);
		      if(idlist.size()==0)
		      {
		    	   out.println("<body style='background-color:#67aded;'>");
					out.write("<center><a type='button' href='deleteaccountmain.jsp' color='blue'>Redirect</a></center>");
					out.println("Account not found....  Please enter correct Customer/SSN id..");
		      }
		      else
		      {
		      request.setAttribute("idlist", idlist);
		      request.getRequestDispatcher("deleteaccount.jsp").forward(request, response);
		      }
		}
		
		
	}

}
