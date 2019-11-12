<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<h1>Ventas del usuario ${clienteLogado.usuario}</h1>
	<table border=1>
		<tr>
			<td>Id Venta</td>
			<td>Id Libro</td>
			<td>fecha</td>
			<td>Titulo</td>						
		</tr>
		<c:forEach var="venta" items="${ventasPorCliente}">				
		<tr>
			<td>${venta.idVEnta}</td>
			<td>${venta.libro.isbn}</td>	
			<td>${venta.fecha}</td>
			<td>${venta.libro.titulo}</td>														
		</tr>			
		</c:forEach>
	</table><br/>
	<div class="form-group">
		<a href="aBienVenida">Menu</a>
	</div>
</div>		
</body>
</html>