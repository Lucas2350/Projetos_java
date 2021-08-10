<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Excluir Paciente</title>
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
</style>
</head>
<body>

      <form action=" ${pageContext.request.contextPath}/excluir_pacientes.pacientes" method="get">
      <table align="center">
      <tr>
		<h2>Exclusao de Pacientes</h2>
	  </tr>	
		<tr>
			<th>Nome: </th>
			<td> <input type="text" name="nome" > </td>
			</tr>
			<tr>
			<td colspan="2" align="center"><input type="submit" name="excluir" value="excluir">
		</tr>
		<tr>
		<td colspan="2" align="left"><b> <c:out value="${mensagem0}" /><br></b>
		    <c:out value="${mensagem1}"/><br>
		    <c:out value="${mensagem2}"/><br>
		   <h2><a href="index.jsp"><h3>Voltar</h2>
		</tr>
      
    
     
      </form>
</body>
</html>