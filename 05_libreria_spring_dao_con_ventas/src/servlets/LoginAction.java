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

import modelo.DaoClientes;
import modelo.DaoTemas;



@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	
	@Autowired
	DaoClientes gestion;
	
	@Autowired
	DaoTemas gtemas;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
		boolean resultado=false;
		if(gestion.autenticar(request.getParameter("user"),request.getParameter("pwd"))){			
			request.setAttribute("temas", gtemas.obtenerTemas());			
            resultado=true;            
		}
		else {
			request.setAttribute("mensaje", "Usuario no registrado");		
		}       
        request.setAttribute("resultado",resultado);
	}
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// Spring solicitando permiso al contenedor web que le deje a spring inyectar sus objetos.
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		super.init(config);
	}
}
