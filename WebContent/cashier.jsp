<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
      *{
             font-family: cursive;
       }
        </style>
<title>Insert title here</title>
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
<%@ include file = "headercashier.jsp" %>
</head>
<body>
<header style="color:black;text-align:center;padding:25px;">
<h1>Welcome <% 
	String id=(String)session.getAttribute("id");
	if(id==null)
		response.sendRedirect("index.html");
	else
		out.println(id);
		
	String type=(String)session.getAttribute("type");
	if(!type.equals("cashier")){
		session.invalidate();
		response.sendRedirect("index.jsp");
	}
	%>
		
	(Cashier)</h1>
</header>
<div align="center">
<form action="SearchSpecificCustomer.jsp"><button type="submit" name="createcustomer" >Get customer details</button></form>
</div><br><br>
<div align="center">
<form action="displayAccountInfo.jsp"><button type="submit" name="viewaccount">Get account details</button></form>
</div><br><br>

<div align="center">
<form action="transfer.jsp"><button type="submit" name="transfer">Transfer</button></form>
</div><br><br>
<div align="center">
<form action="getStatementMain.jsp"><button type="submit" name="statement">Get statement</button></form>
</div><br><br>
</div>

<div style="position:fixed; bottom:5px; left:550px">
<h5><font color="black">Copyright to HJA17GroupF TCS 2018</font></h5>
</div>
</body>
</html>