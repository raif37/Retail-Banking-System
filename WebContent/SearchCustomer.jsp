<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Customer</title>

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
</head>
<body>

	<h1>Welcome <% 
	String id=(String)session.getAttribute("id");
	if(id==null)
		response.sendRedirect("index.jsp");
	else
		out.println(id);%>
</h1>
<center><h1> <font color="black">Search Customer</font> </h1></center><br><br>

<form action="CustomerServlet" method="post">
			<center><table style="width: 25%">
				<tr>
					<td><font color="black">Search By :</font></td>
					<td>
						<select name="value">
							<option value="customerID">Customer ID</option>
							<option value="SSN ID">SSN ID</option>
						</select>
					</td>
				</tr>	
				<tr>
					<td> <font color="black">Enter Value :</font></td>
					<td>
						<input type="text" pattern="[0-9]{9}" title="Should be numberals of 9 digits"  placeholder="Enter value" name="searchval" required >
					</td>
					
				</tr>		
			</table><br>
			<input type="hidden" name="action" value="search">
			<input type="submit" value="Search" /></center>
</form>

<div style="position:fixed; bottom:5px; left:550px">
<h5><font color="black">Copyright to HJA17GroupF TCS 2018</font></h5>
</div>	

</body>
</html>