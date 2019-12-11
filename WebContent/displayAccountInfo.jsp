<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Account Information</title>
<style type="text/css">
      *{
             font-family: cursive;
       }
        </style>
  <%@ include file = "headercashier.jsp" %>
  <br>      
        
<center><h1><font color="black">Account Info</font></h1></center>       
        
<script type="text/javascript">
    function Validate() 
    {
        var select = document.getElementById("select").value;
        var id=document.getElementById("id").value;
        
        if (select== "")
        {
     
            alert("Please select a type!");
           return false;
        }
        else if (id<=0 ||id == "" ) 
       {
   
           alert("Please Enter valid  id");
           return false;
        }
      return true;
    }
    
    function ValidateAccountId() 
     {
           var accountid=document.getElementById("aid").value;
           if (accountid == "")
               {
         
                     alert("Please enter valid account id!");
                     return false;
                }
          return true;
     }
    
    function ValidateSelect()
    { 
        var select2 = document.getElementById("select2").value;
  		if(select2=="0")
    		{
    		
    		alert("Please enter valid Account ID");
            return false;
       }
  		
       return true;
     }
</script><% 
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
<%@page import="java.util.ArrayList" %>
<center><form action="AccountServlet" method="post"  >
   
      <h3><font color="black"> Please select:</font></h3> <br>	
      <select name="type" id="select">
      <option value="">--Select--</option>
      <option value="SSN ID" >SSN ID</option>
      <option value="Customer ID">Customer ID</option>
      </select>
       <font color="black">Enter ID:</font>
      <input type="text" name="id"  id="id" value=0 >
      
      <input type="hidden" name="action" value="view">

       <input type="submit" value="Submit" onclick="return (Validate())"/>
</form></center>
<br></br>

<center><form action="AccountServlet" method="post" >
<br>
<% 
 ArrayList<Integer> allid=new ArrayList<Integer>();
 allid=(ArrayList<Integer>)request.getAttribute("idlist");
 if(allid!=null){
%>
 <select name="accountid" id="selectid">
    
<% 

for(Integer x: allid)
{ %>
	 
     <option value="<%= x %>"><%=x %>
                                
     </option>
   

<%}
%>
  </select>
  <%
	}
	else
  	{
	%>
	<select name="accountid" id="select2">

		<option value="0" >Select Account ID</option>
	</select>
	<%
  	}
  %>

    <input type="hidden" name="action" value="acid">
	
	<input type="submit" value="submit" onclick="return (ValidateSelect())"/>
</form>	</center>
	<hr>
<center><form action="AccountServlet" method="post">
	<h3><font color="black">or</font></h3>
     <font color="black">Account ID: </font>
    <input type="text" name="aid" id="aid">
    
	<input type="hidden" name="action" value="accid">
	<input type="submit" value="Submit" onclick=" return (ValidateAccountId())"/>
		
</form></center>


<div style="position:fixed; bottom:5px; left:560px">
<h5><font color="black">Copyright to HJA17GroupF TCS 2018</font></h5>
</div>
</body>
</html>