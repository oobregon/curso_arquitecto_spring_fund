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
				<td>Isbn</td>
				<td>Titulo</td>
				<td>Autor</td>
				<td>Precio</td>
				<td>Paginas</td>			
			</tr>
			<c:forEach var="libro" items="${libros}">				
			<tr>
				<td>${libro.isbn}</td>
				<td>${libro.titulo}</td>	
				<td>${libro.autor}</td>
				<td>${libro.precio}</td>
				<td>${libro.paginas}</td>											
			</tr>			
			</c:forEach>
		</table><br/>
	</f:form>
	<a href="aTemas">Ver temas</a>
</body>
</html>