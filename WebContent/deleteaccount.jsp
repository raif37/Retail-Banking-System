<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Account</title>


<style type="text/css">
      *{
             font-family: cursive;
       }
        </style>
<% 

String id=(String)session.getAttribute("id");
if(id==null)
	response.sendRedirect("index.jsp");  %>
	<%@ include file = "headercae.jsp" %>
	<br>
<center><h1><font color="black">Delete Account</font></h1></center>
	
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



	
</head>
<body>
<br>
<div align="center">
<table border=1 color="black">
<tr>
<th>Account ID</font></th>
<th>Account Type</font></th>
<th>Balance</font></th>
<th>Delete account</font></th>
</tr>

<%@page import="java.util.ArrayList,com.bean.*" %>
<% ArrayList<Accountf> idlist=(ArrayList<Accountf>)(request.getAttribute("idlist")); 
	for(Accountf cur:idlist){
		
%>
<tr> 
<td> <font color="black"><%=cur.getAccountid()%></font></td>
<td> <font color="black"><%=cur.getAccounttype()%></font></td>
<td> <font color="black"><%=cur.getBalance()%></font> </td>
<td> <form action="DeleteServlet" method="post">
	 <input type="submit" name="Delete" value="Delete">
	 <input type="hidden" name="accountId" value="<%=cur.getAccountid() %>">
	 </form>
	 </td>
  </tr>
<%} %>
</table>
  	</div>
  
  <br>
</div>
<div align="center">
<h5><font color="black">Copyright to HJA17GroupF TCS 2018</font></h5>
</div>
</body>
</html>