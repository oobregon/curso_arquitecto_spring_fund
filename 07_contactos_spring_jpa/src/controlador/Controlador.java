package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlDestino = "entrada.html";
		String op = request.getParameter("op");
		switch(op) {
		case "doContactos": 
			// transferencia de petición de ida y vuelta
			request.getRequestDispatcher("ContactosAction").include(request, response);
			urlDestino = obtenerUrlContactos(request, response);
			break;
			
		case "doAlta": 
			// transferencia de petición de ida y vuelta
			request.getRequestDispatcher("AltaAction").include(request, response);
			urlDestino = "entrada.html";
			break;			
			
		case "doEliminar": 
			// transferencia de petición de ida y vuelta
			request.getRequestDispatcher("EliminarAction").include(request, response);
			urlDestino = obtenerUrlContactos(request, response);
			break;			
			
		case "toDatos": 			
			urlDestino = "datos.html";
			break;
			
		case "toEntrada": 			
			urlDestino = "entrada.html";
			break;
			
		}
		request.getRequestDispatcher(urlDestino).forward(request, response);
	}
	
	private String obtenerUrlContactos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("ContactosAction").include(request, response);
		String url = ((String)request.getAttribute("resultado")).equals("ok")?"listadoContactos.jsp":"sinContactos.html";
		return url;
	}
}
