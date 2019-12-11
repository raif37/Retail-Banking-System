<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Account Information</title>
<style type="text/css">
      *{
             font-family: cursive;
       }
        </style>
        <%@ include file = "headercae.jsp" %>	
        <br>
<center><h1><font color="black">View Account</font></h1></center>
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

</head>
<body>
<br><br><br>
<%@page import="java.util.ArrayList" %>
<center><form action="AccountServlet" method="post">
   
      <h3><font color="black"> Please select:</font></h3> 	
      <select name="type">
      <option value="SSN ID" >SSN ID</option>
      <option value="Customer ID">Customer ID</option>
      </select>
       <font color="black">Enter ID:</font>
      <input type="text" name="id"  value=0>
      
      <input type="hidden" name="action" value="viewaccounttable">
      <input type="submit" value="Submit" />
</form></center>


<div style="position:fixed; bottom:5px; left:550px">
<h5><font color="black">Copyright to HJA17GroupF TCS 2018</font></h5>
</div>
</body>
</html>