<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="java.util.*" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Leitos</title>
<style>  
h1{
color: #ff3b00;
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
color: #ff3b00;
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
}
</style>
</head>
<body>
	<table align="center">
	 <form action="${pageContext.request.contextPath}/cadastrar_leitos.leitos" method="get">
		<h2>Cadastro de Leitos</h2>
		<tr>
			<th>Numero de Camas: </th>
			<td> <input type="text" name="numeroCamas" > </td>
		</tr>
		<tr>
			<th>Localização: </th>
			<td> <input type="text" name="localPredio"> </td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="Enviar">
			
				<h3><a href="index.jsp"><h3>Voltar</h3>
				</td>
			</tr>
		</form>
		<center><resp:out value="${menssagem}" /></center>
	</table>
</body>
</html>