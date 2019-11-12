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
	<h1>Libros por tema</h1>
	<f:form action="obtenerListaLibros" method="post" modelAttribute="Tema">
		<div class="form-group">
			<f:select path="idTema" class="form-control" style="width:20%">
				<f:option value="0" label="-Todos-"/>
				<f:options items="${temas}" itemValue="idTema" itemLabel="tema" />
			</f:select>
		</div>
		<button type="submit" class="btn btn-default">Ver libros</button><br/>
		<div class="form-group">
		<c:choose>
			<c:when test="${not empty libros}">
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
				</table>
			</c:when>
			<c:otherwise>
				<h3 >Sin Libros</h3>
			</c:otherwise>		
		</c:choose>
		</div>
	</f:form>
	<div class="form-group">
		<a href="aBienVenida">Menu</a>
	</div>
</div>		
</body>
</html>