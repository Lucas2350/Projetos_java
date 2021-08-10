<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="java.util.*" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Leitos</title>
<style>  
h1{
color:#ff3b00 ;  
font-family: Arial;
text-align: center;
font-weight: blod;
}
h2{
color: #ff3b00;
font-family: Arial;
text-align: center;
font-weight: blod;
}	
table {
border-width: medium;
border-style: ridge;
border-color: #ff3b00;
border-radius: 30px;
width: 250px;
}
th,tr{
color: #ff3b00;
font-family: Arial;
font-size : 14px;
font-weight: blod;
border-width: medium;
border-style: ridge;
border-color: #ff3b00;
border-radius: 25px;
width: 70px;
height: 70px;
}	
td {
color: #000000;
font-family: Arial;
font-weight: blod;
border-radius: 50px;
}

input {
font-family: Arial;
text-align: center;
font-weight: blod;
border-width: medium;
border-style: ridge;
border-color: #ff3b00;
border-radius: 30px;
width: 150px;
</style>
</head>
<body>
<h1>Lista dos Leitos</h1>
  

  		<table align="center">
   <th>Numero do Leito</th>
   <th>Local no Predio</th>
 
   <c:forEach items="${jspLeitos}" var ="leitos">
       <tr>  
         <td><c:out value="${leitos.numeroLeitos}"/></td>
         <td><c:out value="${leitos.local}"/></td>                 
      </tr>
       
    </c:forEach>
  
  </table>
</body>
</html>