<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Customer</title>
<%@ include file = "headercae.jsp" %>	
<br>

<center><h1><font color="black">Delete Customer</font></h1></center>
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

</head>
<body>
<br><br><br>
	<center><form action="CustomerServlet" method="post">
		<font color="black">Enter Customer Id:</font><input type="text" name="CustId" placeholder="Enter Customer ID" required>
		<input type="hidden" name="action" value="delete">
		<input type="submit" value="Delete"  onclick="{return confirmComplete();}">
	</form></center>
	<script type="text/javascript">
	
	function confirmComplete() {
		
		var answer=confirm("Are you sure you want to continue ?");
		if (answer==true)
		  {
		    return true;
		  }
		else
		  {
		    return false;
		  }
	}
	
	</script>
	

<div style="position:fixed; bottom:5px; left:550px">
<h5><font color="black">Copyright to HJA17GroupF TCS 2018</font></h5>
</div>
	
</body>
</html>