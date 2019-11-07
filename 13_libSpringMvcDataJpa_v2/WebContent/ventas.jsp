<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<f:form>
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
	</f:form>
	<a href="aBienVenida">Menu</a>
</body>
</html>