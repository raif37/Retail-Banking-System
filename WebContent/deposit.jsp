<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deposit amount</title>
<style type="text/css">
      *{
             font-family: cursive;
       }
        </style>
        <%@ include file = "headercashier.jsp" %>
        <br>
<center><h1><font color="black">Deposit Amount</font></h1></center>
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

<div align="center">
<br><br><br>
	<form action="TransactionServlet" method="post" name="f1">
		<font color="black">Enter amount: Rs </font><input type="text" name="amount">Rs<br><br>
		<input type="submit" value="submit" onclick="return validate()"><br>
		<input type="hidden"  name="action" value="deposit">
	</form>
</div>

<div align="center">
<h5><font color="black">Copyright to HJA17GroupF TCS 2018</font></h5>
</div>
</body>

<script>
	function validate(){
		var amt=document.f1.amount.value;
		if(amt=="" ||  isNaN(amt) || amt<=0){
			alert("Enter a valid amount");
			return false;
		}
		return true;
			
	}
</script>
</html>