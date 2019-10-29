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

import javabeans.Cliente;
import modelo.DaoClientes;



@WebServlet("/RegistroAction")
public class RegistroAction extends HttpServlet {
	
	@Autowired
	DaoClientes gestion;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
                Cliente c=new Cliente(0,request.getParameter("usuario"),
                request.getParameter("password"),
                        request.getParameter("email"),
                        Integer.parseInt(request.getParameter("telefono")));
		gestion.registrar(c);			
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// Spring solicitando permiso al contenedor web que le deje a spring inyectar sus objetos.
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		super.init(config);
	}
}
