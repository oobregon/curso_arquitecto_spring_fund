<%@page import="java.util.List"%>
<%@page import="model.Contacto"%>
<%@page import="daos.DaoContactosImpl"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
	<c:set var="agenda" value="${requestScope.agenda}" />	
	<table border=1>
		<tr>
			<td>Id Contacto</td>
			<td>Nombre</td>
			<td>Email</td>
			<td>Edad</td>
		</tr>
		<c:forEach var="contacto" items="${agenda}">				
		<tr>
			<td>${contacto.idContacto}</td>
			<td>${contacto.nombre}</td>
			<td>${contacto.email}</td>			
			<td>${contacto.edad}</td>						
			<td><a href="Controlador?op=doEliminar&idContacto=${contacto.idContacto}">Eliminar</a></td>
		</tr>			
		</c:forEach>
	</table>
	<br/><br/>	
	<a href="Controlador?op=toEntrada">Volver</a>
</body>
</html>