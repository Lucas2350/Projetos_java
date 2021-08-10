<%@      taglib prefix="resp" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
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
	
	<form action=" ${pageContext.request.contextPath}/cadastrar_pacientes.pacientes" method="get">
		
		<table align="center">
		<h2>Cadastro de Pacientes</h2>
		<tr>
			<th>Nome: </th>
			<td> <input type="text" name="nome" > </td>
		</tr>
		<tr>
			<th>Convenio: </th>
			<td> <input type="text" name="convenio"> </td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" name="Enviar" value="Enviar">
				<h3><a href="index.jsp"><h3>Voltar</h3>
				</td>
			</tr>
		</form>
		<center><resp:out value="${menssagem}" /></center>
	</table>


</body>
</html>