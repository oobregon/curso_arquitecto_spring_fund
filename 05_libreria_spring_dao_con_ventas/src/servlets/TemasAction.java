package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import modelo.DaoTemas;
import modelo.DaoTemasImpl;


/**
 * Servlet implementation class TemasAction
 */
@WebServlet("/TemasAction")
public class TemasAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Autowired
	DaoTemas gtemas;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setAttribute("temas", gtemas.obtenerTemas());	
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// Spring solicitando permiso al contenedor web que le deje a spring inyectar sus objetos.
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		super.init(config);
	}
}
