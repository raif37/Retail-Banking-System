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
<script type="text/javascript">
 function validlogin(){
		var username=document.getElementById("username").value.trim();
		var password=document.getElementById("password").value.trim();
		 document.getElementById("errusername").innerHTML="";
		 document.getElementById("errpassword").innerHTML=""; 
		if(username==""){
			document.getElementById("errusername").innerHTML="Please enter username";
			return false;
		}
		if(password==""){
			document.getElementById("errpassword").innerHTML="Please enter password";
			return false;
		}
			
			
		return true;
	}

        </script>
        <%@ include file = "headerlogin.jsp" %>
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
<div class="loginform">
	<br>
	<br>

<h2 style="text-align:center;"><font color="black">Employee Login </font></h2>
<form name="form1" action="LoginServlet" onsubmit="return validlogin()" method="post" >


<center>
		
			<br>
			<br>
			<br>
<label for="uname"><font color="black"> UserName:<font color="red">*</font></font></label>
			<input type="text"  id="username" placeholder="Enter UserName" name="empid" 
					pattern="[a-zA-Z0-9]{8,}" title="Can be alphabetic or alphanumeric, and at least 8 or more characters"><font color="red"><span id="errusername"></span></font>
			<br>
			<br>
			<br><label for="psw"><font color="black"> Password:<font color="red">*</font></font></label>
			<input type="password"  id="password" placeholder="Enter password" name="pwd"  
					pattern="[a-zA-Z0-9]{10,}" title="Can be alphabetic or alphanumeric, and at least 10 or more characters"><font color="red"><span id="errpassword"></span></font>
			<br>
			<br>
<button class="btn btn-success" type="submit" name="action" value="Login">Login</button>
			
<button class="btn btn-danger" type="reset" name="action" value="reset">Reset</button>

			<br><br>
			<br>
			<br>
			<br>
			<br>
			<br>
			</center>

        
	<% 
        if(request.getAttribute("status")!=null){
        	int status=(Integer)request.getAttribute("status");
			if(status==0){
				out.println("<p style=\"color:red; text-align:center;\">	Wrong credentials<p>");
			}
			else if(status==-1){
				out.println("<p style=\"color:red; text-align:center;\">	Failed due to some internal error<p>");
			}
        }
	%>

</form>




</div>

<div align="center">
<h5><font color="black">Copyright to HJA17GroupF TCS 2018</font></h5>
</div>

</body>
</html>