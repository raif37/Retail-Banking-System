<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>
<<style type="text/css">
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
<script>
    history.forward();
</script>
</head>
<body>

<%@ page trimDirectiveWhitespaces="true" %>
<%
try {
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);
    if (session.getAttribute("id")==null) {
        response.sendRedirect("index.jsp");
    }
    else {}
}
catch(Exception ex) {
    out.println(ex);
}
%>
<%
	session.invalidate();
%>
<center><h1><font color="black"> You have been logged out!!!...Please Login again..</font></h1></center><br><br><br>
<div align="center">
<form action="index.jsp">
   <input type="submit" value="Go to Home" />
</form>
</div>

</body>

</html>