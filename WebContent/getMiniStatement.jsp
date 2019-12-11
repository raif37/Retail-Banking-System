<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Statement</title>
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
	<br>
<center><h1><font color="black">Mini Statement</font></h1></center>		
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
<br>
<form action="TransactionServlet"  method="post" name="f1">
<font color="black">Account Id : </font><input type="text" name="accountId" required>
<font color="black">Select Transactions :</font> <select name="days" required>
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
  <option value="5">5</option>
  <option value="6">6</option>
  <option value="7">7</option>
  <option value="8">8</option>
  <option value="9">9</option>
  <option value="10">10</option>
</select>
<input type="submit" value="submit"> 
<input type="hidden" name="action" value="getStatement">
<input type="hidden" name="type" value="mini">
</form>

<form>

</form>
 
</form>
</div>

<div align="center">
<h5><font color="black">Copyright to HJA17GroupF TCS 2018</font></h5>
</div>

</body>
</html>