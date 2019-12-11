<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
      *{
             font-family: cursive;
       }
        </style>
        <style>
body{
/* color:#4169E1;
background-color: #FFFAFA;
 */
color:skyBlue;
background-color: skyBlue;


}
table {
    border-collapse: collapse;
    width: 100%;
}


th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

tr:hover {background-color:#B0E0E6;}
</style>
<%@ include file = "headercae.jsp" %>
</head>
<body>
<header style="color:black;text-align:center;padding:25px;">
<h1>Welcome <% 
	String sessionId=(String)session.getAttribute("sessionId");
	if(sessionId==null)
		response.sendRedirect("index.jsp");
	else{
		if(session.getId()!=sessionId)
			response.sendRedirect("index.jsp");
	}
	String id=(String)session.getAttribute("id");
	if(id==null)
		response.sendRedirect("index.jsp");
	else
		out.println(id);
	%>
	(Executive)</h1>
	</header>
	
	<%String type=(String)session.getAttribute("type");
	if(!type.equals("cae")){
		session.invalidate();
		response.sendRedirect("index.jsp");
	}
	 %>
	
<div align="center">
<form action="createcustomer.jsp"><button type="submit" name="createcustomer" >Create Customer</button></form>
</div><br><br>
<div align="center">
<form action="SearchCustomer.jsp"><button type="submit" name="updatecustomer">Update Customer</button></form>
</div><br><br>
<div align="center">
<form action="deleteCustomer.jsp"><button type="submit" name="deletecustomer">Delete Customer</button></form>
</div><br><br>
<div align="center">
<form action="createaccount.jsp"><button type="submit" name="createaccoutn">Create Account</button></form>
</div><br><br>
<div align="center">
<form action="deleteaccountmain.jsp"><button type="submit" name="deleteaccount">Delete Account</button></form>
</div><br><br>
<div align="center">
<form action="CustomerServlet"><button type="submit" method="get" name="viewallcustomerstatus">View all customer status</button>
<input type="hidden" name="action" value="viewallcustomerstatus">
</form>
</div><br><br>

<div align="center">
<form action="AccountServlet"><button type="submit" method="get" name="viewallaccountstatus">View all account status</button>
<input type="hidden" name="action" value="viewallaccountstatus">
</form>
</div>

</div><br><br><br><br>
<div style="position:fixed; bottom:5px; left:550px">
<h5><font color="black">Copyright to HJA17GroupF TCS 2018</font></h5>
</div>
</body>
</html>