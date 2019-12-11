<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Customer</title>
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
<h1>Welcome <% 
	String id=(String)session.getAttribute("id");
	if(id==null)
		response.sendRedirect("index.jsp");
	else
		out.println(id);%>
	</h1>
<center><h1><font color="black">Update Customer</font></h1></center>
<form action="CustomerServlet" method="post">
			<center><table style="width: 50%">
				<tr>
					<td><font color="black">Customer ID :</font></td>
					<td><input type="text"  value="<%=request.getAttribute("id") %>" disabled="disabled"/></td>
				</tr>
				<tr>
					<td><font color="black">SSN :</font></td>
					<td><input type="text"  value="<%=request.getAttribute("ssn") %>" disabled="disabled"/></td>
				</tr>	
				<tr>
					<td><font color="black">Customer Name:</font></td>
					<td><input type="text" name="CustomerName" value="<%=request.getAttribute("name") %>" required/></td>
				</tr>
				<tr>
					<td><font color="black">Age:</font></td>
					<td><input type="text" name="age" value="<%= request.getAttribute("age") %>" required/></td>
				</tr>
				<tr>
					<td><font color="black">Address Line 1:</font></td>
					<td><input type="text" name="address1" value="<%= request.getAttribute("add1") %>" required /></td>
				</tr>
				<tr>
					<td><font color="black">Address Line 2:</font></td>
					<td><input type="text" name="address2" value="<%= request.getAttribute("add2") %>" /></td>
				</tr>
				<tr>
					<td><font color="black">City :</font></td>
					<td><input type="text" name="city" value="<%= request.getAttribute("city") %>" required/></td>
				</tr>
				<tr>
					<td><font color="black">State :</font></td>
					<td><input type="text" name="state" value="<%= request.getAttribute("state") %>" required/></td>
				</tr>
				<tr>
					<td><font color="black">Status :</font></td>
					<td><input type="text" name="status" value="<%= request.getAttribute("status") %>" required/></td>
				</tr>
				<tr>
					<td><font color="black">Message :</font></td>
					<td><input type="text" name="message" value="<%= request.getAttribute("message") %>" required/></td>
				</tr>
				
				
			</table></center>
			<input type="hidden" name="action" value="update">
			<input type="hidden" name="customerID" value="<%= request.getAttribute("id")%>">
			<input type="hidden" name="SSN" value="<%= request.getAttribute("ssn")%>">
			<center><input type="submit" value="Update" /></form></center>


<div align="center">
<h5><font color="black">Copyright to HJA17GroupF TCS 2018</font></h5>
</div>

</body>
</html>