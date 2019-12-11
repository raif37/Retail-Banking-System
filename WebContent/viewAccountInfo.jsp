<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Account Info</title>
<style type="text/css">
      *{
             font-family: cursive;
       }
        </style>

<% 
String id=(String)session.getAttribute("id");
if(id==null)
	response.sendRedirect("index.jsp");  %>
	
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
	<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
    padding: 10px;
}
th {
    background-color: black;
    color: white;
}
</style>

<%@ include file = "headercashier.jsp" %>
</head>
<body>
<br>
<div align="center">
<table color="black" border="1">
<th>Customer ID</th>
<th>Account ID</th>
<th>Account Type</th>
<th>Balance></th>
<tr> 
<td><font color="black"><%=request.getAttribute("custid")%></font></td>
<td><font color="black"> <%=request.getAttribute("accid")%></font></td>
<td> <font color="black"><%=request.getAttribute("atype")%></font></td>
<td> <font color="black"> <%=request.getAttribute("bal")%> </font></td>
  </tr>
</table>
  </div>
  <br>
<div align="center">
	<form action="deposit.jsp"><button type="submit" name="deposit">Deposit</button></form>
	<br>
	<form action="withdraw.jsp"><button type="submit" name="withdraw">Withdraw</button></form>
</div>

<div align="center">
<h5><font color="black">Copyright to HJA17GroupF TCS 2018</font></h5>
</div>
</body>
</html>