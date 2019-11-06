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
	<f:form action="obtenerListaLibros" method="post" modelAttribute="tema">
		<table border=1>
		<tr>
			<td>Id Tema</td>
			<td>Temática</td>			
		</tr>
		<c:forEach var="tema" items="${temas}">				
		<tr>
			<td>${tema.idTema}</td>
			<td>${tema.tema}</td>												
		</tr>			
		</c:forEach>
	</table><br/>
	<f:select path="idTema">
		<option value="0">Todos</option>						
		<c:forEach var="t" items="${temas}">
			<option value="${t.idTema}">${t.tema}</option>		    		
		</c:forEach>								
	</f:select><br/><br/>
	<button type="submit">Ver libros</button>
	</f:form>
	<a href="aBienVenida">Menu</a>
</body>
</html>