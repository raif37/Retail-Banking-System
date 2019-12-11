<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">


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


<% 
String id=(String)session.getAttribute("id");
if(id==null)
	response.sendRedirect("index.jsp");  %>
</head>
<body>

	<form action="AccountServlet" method="post">
  		<div class="container">
    		<h1><font color="black">Account Details</font></h1>
    		<p><font color="black">Please fill in this form to create an account.</font></p>
    		<hr>
			<label for="Custid"><b><font color="black">Customer ID:</font></b></br></br></label>
    		<input type="text" placeholder="Enter Customer ID" name="custid" required>
    		<hr>
			<b><font color="black">Account Type:</font></b></br></br>
			<select name="acctype">
				<option value="Savings">Savings Account</option>
				<option value="Current">Current Account</option>
			</select></br></br>
			<label for="depamt"><b><font color="black">Deposit Amount:</font></b></br></br></label>
    		<input type="text" placeholder="Enter Deposit Amount" name="depamt" required>
    		<hr>
    		
			
			<button type="submit" class="registerbtn">Register</button>
  		</div>
 		<input type="hidden" name="action" value="add">
 	</form>
</div>

<div style="position:fixed; bottom:5px; left:550px">
<h5><font color="black">Copyright to HJA17GroupF TCS 2018</font></h5>
</div>
</body>
</html>
