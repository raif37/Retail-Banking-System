package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.service.*;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
		PrintWriter out = response.getWriter();
		//String action = request.getParameter("action");
		AccountService service = new AccountService();
		int Account_Id = Integer.parseInt(request.getParameter("accountId"));
/*		String Account_Type = request.getParameter("acctype");
		//double Deposit_Amount = request.getParameter("depamt");*/
		int result = service.deleteAcc(Account_Id);
		if(result>=1){
			out.println("<body style='background-color:#67aded;'>");
			out.write("<center><a type='button' href='cae.jsp' color='blue'>Redirect</a></center>");
			out.println("Account Deletion Initiated Successfully");
		}
		else{
			out.println("<body style='background-color:#67aded;'>");
			out.write("<center><a type='button' href='cae.jsp' color='blue'>Redirect</a></center>");
			out.println("OOpppss....error occurred!!!!!");	
	}
	}
}