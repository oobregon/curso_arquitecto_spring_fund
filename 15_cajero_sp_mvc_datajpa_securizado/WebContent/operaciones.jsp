<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
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

<script type="text/javascript">

	function cambiarCuenta(elemento) {
		var url = "aCambioDeCuenta?cuenta="+elemento.val();	
		$.get(url);
		window.location.href="operaciones.jsp";
	}
	
	function cambiarCuentaPorAjax(elemento) {
		var url = "cambiarCuentaPorAjax?cuenta="+elemento.val();			
		$.get(url,function(respuesta,estado) {
			procesarRespuesta(respuesta);
		});
	}
		
	function procesarRespuesta(respuesta) {
		var json = JSON.parse(respuesta);
		$("#cuentaAutenticada").text(json[0].numeroCuenta);
		$("#saldoCuentaAutenticada").text(json[0].saldo);	
	}
	
</script>
</head>
<body>
<div class="container">
	<h1>Menu de Usuario</h1>
	<form>
		<h2>Cuenta:<label id="cuentaAutenticada">${sessionScope.cuentaAutenticada.numeroCuenta}</label></h2>
		<h5>(Saldo:<label id="saldoCuentaAutenticada">${sessionScope.cuentaAutenticada.saldo}</label>)</h5>
		<h3>Operaciones</h1>		
		<div class="form-group">					
			<a href="aIngreso">Realizar ingreso</a><br/>
			<a href="aExtraccion">Realizar extracción</a><br/>
			<a href="aTransferencia">Realizar transferencia</a><br/>
			<a href="movimientos">Ver movimientos</a><br/>
			<a href="#" id="cambiarCuenta" onclick="cambiarCuentaPorAjax($('#cuentaObjetivo'));">Cambiar a cuenta:</a>
			<input type="text" id="cuentaObjetivo" class="form-group" style="width:10%" />	
		</div>	
		<br/><br/>
		<div class="form-group">
			<a href="aMenu">Salir</a>
		</div>	
	</form>			
</div>
</body>
</html>