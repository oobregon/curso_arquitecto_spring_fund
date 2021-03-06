package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import daos.DaoContactos;
import model.Contacto;

@WebServlet("/ContactosAction")
public class ContactosAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	DaoContactos daoCont;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		List<Contacto> agenda = daoCont.dameContactos();
		if(agenda.size() > 0) {
			request.setAttribute("resultado","ok");			
			request.setAttribute("agenda",agenda);
			
		} else {
			request.setAttribute("resultado","ko");
		}		
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// Spring solicitando permiso al contenedor web que le deje a spring inyectar sus objetos.
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		super.init(config);
	}
}