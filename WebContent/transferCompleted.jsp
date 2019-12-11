<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transfer completed</title>
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

<%@ include file = "headercashier.jsp" %>
</head>


<body>
<div align="center">
<h1><font color="black">Amount transfer completed successfully</font></h1>
<br><br>
<h3><font color="black">Source account details</font></h3>
<br><br>
<table color="black" border="2" >
<tr>
<th><font color="black">Source account id</font></th>
<th><font color="black">Balance before transfer</font></th>
<th><font color="black">Latest balance</font></th>
</tr>
<tr>
<%@page import="java.util.ArrayList" %>
<% ArrayList details=(ArrayList)request.getAttribute("details");%>
<tr>
<td><font color="black"><%= details.get(1)%></font></td>
<td><font color="black"><%= details.get(2)%></font></td>
<td><font color="black"><%= details.get(3)%></font></td>
</tr>
</table>


<br><br>
<h3><font color="black">Target account details</font></h3>
<br><br>
<table color="black" border="2">
<tr>
<th><font color="black">Target account id</font></th>
<th><font color="black">Balance before transfer</font></th>
<th><font color="black">Latest balance</font></th>
</tr>
<tr>
<tr>
<td><font color="black"><%= details.get(4)%></font></td>
<td><font color="black"><%= details.get(5)%></font></td>
<td><font color="black"><%= details.get(6)%></font></td>
</tr>
</table>

</div>

<div align="center">
<h5><font color="black">Copyright to HJA17GroupF TCS 2018</font></h5>
</div>
</body>
</html>