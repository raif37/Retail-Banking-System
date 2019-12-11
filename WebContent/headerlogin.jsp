<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>headerLogin</title>

<style>
* {box-sizing: border-box;}

body { 
  margin: 0;
  font-family: cursive;
}

.header {
  overflow: hidden;
  background-color: #999999;
  padding: 10px 10px;
}
.header img {
  float: left;
  width: 90px;
  height: 70px;
  background: #555;
}
.header a {
  float: left;
  color: black;
  text-align: center;
  padding: 12px;
  text-decoration: none;
  font-size: 18px; 
  line-height: 25px;
  border-radius: 4px;
}
.header p {
  float: left;
  color: black;
  text-align: center;
  padding: 8px;
  text-decoration: none;
  font-size: 12px; 
  line-height: 18px;
  border-radius: 2px;
}

.header a.logo {
  font-size: 25px;
  font-weight: bold;
}

.header a:hover {
  background-color: #ddd;
  color: black;
}

 
 /* 
 .header p:hover {
  position: relative;
  top: 18px;
  left: 10px;
  }
  */
.header a.active {
  background-color: dodgerblue;
  color: white;
}

.header-right {
  float: right;
}

@media screen and (max-width: 500px) {
  .header a {
    float: none;
    display: block;
    text-align: left;
  }
  .header-right {
    float: none;
  }
}
</style>
</head>
<body>
<div class="header">
<img src="logo.jpg" alt="logo" />
  <a  class="logo" href="#about">Bank of TCS</a>
  <div style="position:absolute; top:40px; left:120px">
  <p> You SAVE, We SECURE .... </p>
  </div>
  <div class="header-right">
   <a href="#about">About</a>
    <a  href="index.jsp">Home</a>
    
   
  </div>
</div>

</body>
</html>