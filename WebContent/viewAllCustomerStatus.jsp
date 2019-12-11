<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Customer Status</title>
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
<% 
String id=(String)session.getAttribute("id");
if(id==null)
	response.sendRedirect("index.jsp");  %>
	
<%@ include file = "headercae.jsp" %>	
	
</head>
<body>

<br><br>
<%@page import="com.bean.*,java.util.ArrayList,java.sql.Date,java.text.DateFormat,java.text.SimpleDateFormat"%>
<% ArrayList<CustomerStatusf> list=(ArrayList<CustomerStatusf>)request.getAttribute("list");%>

<div align="center">
<table style="width:100%" border: 1px solid black;>
<caption><h1><font color="black">All customer status</font></h1></caption>
<tr>
<th>Customer ID</th>
<th>SSN ID</th>
<th>Status</th>
<th>Message</th>
<th>Last updated</th>
<th>Refresh Buttons</th>
</tr>

<%
DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
for(CustomerStatusf cust:list){
%>
<tr>
<td><font color="black"><%= cust.getCustomerid() %></font></td>
<td><font color="black"><%=cust.getSsnid()%></font></td>
<td><font color="black"><%=cust.getStatus() %></font></td>
<td><font color="black"><%=cust.getMessage() %></font></td>
<td><font color="black"><%=cust.getLastUpdated()%></font></td>
<td><font color="black"><button type="button" onclick="refresh()">Refresh</button>
</tr>
<%}%>

</table>

</div>

<div align="center">
<h5><font color="black">Copyright to HJA17GroupF TCS 2018</font></h5>
</div>
</body>

<script>
function refresh(){
	location.reload(true);
}

</script>
</html>