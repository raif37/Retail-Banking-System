package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.*;
import com.service.*;

/**
 * Servlet implementation class TransactionServlet
 */
@WebServlet("/TransactionServlet")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		PrintWriter out = response.getWriter();
		if(action.equals("deposit")){
			TransactionService service=new TransactionService();
			Accountf account=(Accountf)request.getSession().getAttribute("account");
			double amount=Double.parseDouble(request.getParameter("amount"));
			ArrayList status=service.deposit(account,amount);
			
			
			if((Integer)status.get(0)==1){
				request.setAttribute("status", status);
				request.getRequestDispatcher("transactionsuccess.jsp").forward(request,response);
			}
			else{
				out.println("<body style='background-color:#67aded;'>");
				out.write("<center><a type='button' href='cashier.jsp' color='blue'>Redirect</a></center>");
				out.println("fail");
			}
        	
		}
		else if(action.equals("withdraw")){
			TransactionService service=new TransactionService();
			Accountf account=(Accountf)request.getSession().getAttribute("account");
			double amount=Double.parseDouble(request.getParameter("amount"));
			ArrayList status=service.withdraw(account,amount);
			if((Integer)status.get(0)==1){
				request.setAttribute("status", status);
				request.getRequestDispatcher("transactionsuccess.jsp").forward(request,response);;
			}
			else if((Integer)status.get(0)==0){
				out.println("<body style='background-color:#67aded;'>");
				out.write("<center><a type='button' href='cashier.jsp' color='blue'>Redirect</a></center>");
				out.println("internal error");
			}
			else if((Integer)status.get(0)==-1){
				out.println("<body style='background-color:#67aded;'>");
				out.write("<center><a type='button' href='cashier.jsp' color='blue'>Redirect</a></center>");
				out.println("Not enough balance");
			}
		}
		else if(action.equals("transfer")){
			TransactionService service=new TransactionService();
			int amount=Integer.parseInt(request.getParameter("amount"));
			int source=Integer.parseInt(request.getParameter("source"));
			int target=Integer.parseInt(request.getParameter("target"));
			
			ArrayList ret=service.transfer(amount,source,target);
			
			if(ret.get(0).equals("Amount transfer completed successfully"))
			{
				request.setAttribute("details", ret);
				request.getRequestDispatcher("transferCompleted.jsp").forward(request, response);
			}
			else
				out.println("<body style='background-color:#67aded;'>");
			out.write("<center><a type='button' href='cashier.jsp' color='blue'>Redirect</a></center>");
				out.println(ret.get(0).toString());
		}
		else if(action.equals("getStatement")){
			TransactionService service=new TransactionService();
			String type=request.getParameter("type");
			int accountId=Integer.parseInt(request.getParameter("accountId"));
			if(type.equals("mini")){
				int days=Integer.parseInt(request.getParameter("days"));
				ArrayList<Transactionf> list= service.getStatement(accountId, days);
				//System.out.println(list);
				request.setAttribute("list", list);
				request.getRequestDispatcher("viewStatement.jsp").forward(request, response);
			}
			else if(type.equals("date")){
				String start=request.getParameter("start");
				
				try{
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date startDate= formatter.parse(start);
				//java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());  
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(startDate);
				cal.set(Calendar.MILLISECOND, 0);
				
				Timestamp startTimestamp=new java.sql.Timestamp(cal.getTimeInMillis());
				
				String end=request.getParameter("end");
				Date endDate= formatter.parse(end);
				//java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());  
				
				Calendar cal2 = Calendar.getInstance();
				cal2.setTime(endDate);
				cal2.set(Calendar.MILLISECOND, 0);
				
				Timestamp endTimestamp=new java.sql.Timestamp(cal2.getTimeInMillis());
				
				//System.out.println(start);
				//System.out.println(startDate);
				//System.out.println(endDate);
				
				System.out.println(startDate);
				System.out.println(endDate);
				ArrayList<Transactionf> list= service.getStatement(accountId, startTimestamp,endTimestamp);
				request.setAttribute("list", list);
				request.getRequestDispatcher("viewStatement.jsp").forward(request, response);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}

}
