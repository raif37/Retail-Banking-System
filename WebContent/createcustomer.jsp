<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
      *{
             font-family: cursive;
       }
        </style>
       



<script>
function myFunction() {
    var ssn,custid,age,address,city,state;

    // Get the value of the input field with id="numb"
    ssn = document.getElementById("ssn1").value;
    custname= document.getElementById("custname1").value;
    age= document.getElementById("age1").value;
    add1= document.getElementById("add1").value;
    city= document.getElementById("city1").value;
    state= document.getElementById("state1").value;
    if (isNaN(ssn) || ssn < 99999999 || ssn > 999999999) {
       alert("Please Enter valid SSN ID");
       return false;
    } 
   else if (!isNaN(custname) || custname=="") {
       alert("Please Enter Customer Name");
       return false;
    }
   else if(isNaN(age) || age <0 || age > 100)
   {
       alert("Please enter valid Age");
       return false;
   } 
   else if (add1=="") {
        alert("Please Enter address");
        return false;
    }
    else if (!isNaN(city) || city=="") {
        alert("Please Enter City");
        return false;
    }
    else if (!isNaN(state) || state=="") {
        alert("Please Enter state");
        return false;
    }
 
    }
</script>
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
<h1><font color="black">Add Customer</font></h1>
<form action="CustomerServlet" method="post">
<table style="with: 50%">
<tr>
					<td><font color="black">SSN :</font></td>
					<td><input id="ssn1" type="text" name="SSN" required></td>
				</tr>
			
				<tr>
					<td><font color="black">Customer Name:</font></td>
					<td><input id="custname1" type="text" name="CustomerName" required/></td>
				</tr>
					<tr>
					<td><font color="black">Age:</font></td>
					<td><input id="age1" type="text" name="age" required/></td>
				</tr>
				<tr>
					<td><font color="black">Address Line 1:</font></td>
					<td><input id="add1" type="text" name="address1" required /></td>
				</tr>
				<tr>
					<td><font color="black">Address Line 2:</font></td>
					<td><input  type="text" name="address2" /></td>
				</tr>
				<tr>
					<td><font color="black">City :</font></td>
					<td><input id="city1" type="text" name="city" required/></td>
				</tr>
				<tr>
					<td><font color="black">State:</font></td>
					<td><input id="state1" type="text" name="state" required/></td>
				</tr>
				


            </table><br><br>
       <input type="hidden" name="action" value="add">
     <center> <input type="submit" value="submit" onclick=" return (myFunction())" style="width: 121px; "></center>
</form>
</div>
<div align="center">
<h5><font color="black">Copyright to HJA17GroupF TCS 2018</font></h5>
</div>

</body>
</html>