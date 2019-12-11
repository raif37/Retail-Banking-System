<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Details</title>
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
<%@ include file = "headercashier.jsp" %>
</head>
<body>

	<h1>Welcome <% 
	String id=(String)session.getAttribute("id");
	if(id==null)
		response.sendRedirect("index.jsp");
	else
		out.println(id);%>
	</h1>
	<div align="center">
	<h1><font color="black">Customer Details</font></h1>
	<form action="cashier.jsp" method="post">
	
			<table style="width: 50%" border="1" color="black">
				<tr>
					<td><font color="black">Customer ID :</font></td>
					<td><font color="black"><%= request.getAttribute("id") %></font></td>
				</tr>
				<tr>
					<td><font color="black">SSN :</font></td>
					<td><font color="black"><%=request.getAttribute("ssn") %></font></td>
				</tr>	
				<tr>
					<td><font color="black">Customer Name:</font></td>
					<td><font color="black"><%=request.getAttribute("name") %></font></td>
				</tr>
				<tr>
					<td><font color="black">Age:</font></td>
					<td><font color="black"><%= request.getAttribute("age") %></font></td>
				</tr>
				<tr>
					<td><font color="black">Address Line 1:</font></td>
					<td><font color="black"><%= request.getAttribute("add1") %></font></td>
				</tr>
				<tr>
					<td><font color="black">Address Line 2:</font></td>
					<td><font color="black"><%= request.getAttribute("add2") %></font></td>
				</tr>
				<tr>
					<td><font color="black">City :</font></td>
					<td><font color="black"><%= request.getAttribute("city") %></font></td>
				</tr>
				<tr>
					<td><font color="black">State:</font></td>
					<td><font color="black"><%= request.getAttribute("state") %></font></td>
				</tr>
				<tr>
					<td><font color="black">Status:</font></td>
					<td><font color="black"><%= request.getAttribute("status") %></font></td>
				</tr>
				<tr>
					<td><font color="black">Message :</font></td>
					<td><font color="black"><%= request.getAttribute("message") %></font></td>
				</tr>
				<tr>
					<td><font color="black">Last Updated :</font></td>
					<td><font color="black"><%= request.getAttribute("last_updated") %></font></td>
				</tr>
				
				
			</table>
			<input type="submit" value="Home" /></form>
			
	</div>
	
<div align="center">
<h5><font color="black">Copyright to HJA17GroupF TCS 2018</font></h5>
</div>
	

</body>
</html>