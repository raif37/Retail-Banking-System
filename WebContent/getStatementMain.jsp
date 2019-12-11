<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get statement</title>
<style type="text/css">
      *{
             font-family: cursive;
       }
        </style>
<% 
String id=(String)session.getAttribute("id");
if(id==null)
	response.sendRedirect("index.jsp");  %>
	<%@ include file = "headercashier.jsp" %>
<br><center><h1><font color="black">Statement</font></h1></center>	
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

<div align="center">
<br><br>
<form action="getMiniStatement.jsp"><button type="submit" name="getMiniStatement" >Get mini statement</button></form>
</div><br><br>

<div align="center">
<form action="getStatementByDate.jsp"><button type="submit" name="getStatementByDate" >Get statement between dates</button></form>
</div><br><br>


<div style="position:fixed; bottom:5px; left:550px">
<h5><font color="black">Copyright to HJA17GroupF TCS 2018</font></h5>
</div>

</body>
</html>