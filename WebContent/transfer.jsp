<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transfer</title>
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
	
	<center><h1><font color="black">Transfer Amount</font></h1></center>
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
<br><br>
<div align="center">

<form action="TransactionServlet" method="post" name="transferForm">
<br><br>
	<font color="black">Transfer amount: </font><input type="text" name="amount"><br><br>
	<font color="black">Source account id: </font><input type="text" name="source"><br><br>
	<font color="black">Target account id: </font><input type="text" name="target"><br><br>

	<input type="submit" value="submit" onclick="return validate()"><br>
	<input type="hidden"  name="action" value="transfer">

</form>

</div>

<script>
function validate(){
	var amount=document.transferForm.amount.value;
	if(amount=="" || isNaN(amount) ||amount<0 ){
		alert("Please enter valid amount");
		return false;
	}
	var sourceId=document.transferForm.source.value;
	if(sourceId=="" || isNaN(sourceId) || sourceId<0){
		alert("Please enter valid source account id");
		return false;
	}
	var targetId=document.transferForm.target.value;
	if(targetId=="" || isNaN(targetId) || targetId<0){
		alert("Please enter valid target account id");
		return false;
	}
	return confirm("Are you sure");
}
</script>


<div style="position:fixed; bottom:5px; left:550px">
<h5><font color="black">Copyright to HJA17GroupF TCS 2018</font></h5>
</div>
</body>
</html>