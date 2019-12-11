package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.bean.Employeef;
import com.dao.Logindao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(LoginServlet.class); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");  
	    String name=request.getParameter("empid");  
	    String password=request.getParameter("pwd");  
	    Employeef emp=new Employeef(name, password);
	    
	    Logindao login=new Logindao();
	    int r=login.checkEmployee(emp);  
	    request.setAttribute("status", r);
	    
	    HttpSession session=request.getSession();
	    session.setAttribute("sessionId", session.getId());
	    
	    if(r==0 || r==-1){
	    	request.getRequestDispatcher("index.jsp").forward(request,response);
	    }
	    else if(r==1){
	    	//LOGGER.info("This is a logging statement from log4j");
	    	logger.info("logged in user is "+name+" as executive ");
			logger.debug("inside login controller");
	    	request.getSession().setAttribute("id", name);
	    	request.getSession().setAttribute("type", "cae");
	    	request.getRequestDispatcher("cae.jsp").forward(request,response);
	    }
	    else if(r==2){
	    	logger.info("logged in user is "+name+" as cashier");
			logger.debug("inside login controller");
	    	request.getSession().setAttribute("id", name);
	    	request.getSession().setAttribute("type", "cashier");
	    	request.getRequestDispatcher("cashier.jsp").forward(request,response);
	    }

		
	}
	}


