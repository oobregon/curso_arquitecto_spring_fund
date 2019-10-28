package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoContactos;
import fabricas.FactoryDao;
import model.Contacto;


// Los controladores de accion forman parte del Controlador (Patrón MVC)
@WebServlet("/ContactosAction")
public class ContactosAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoContactos dao = FactoryDao.obtenerDaoContactos();
		List<Contacto> agenda = dao.dameContactos();
		if(agenda.size() > 0) {
			request.setAttribute("resultado","ok");			
			request.setAttribute("agenda",agenda);
			
		} else {
			request.setAttribute("resultado","ko");
		}		
	}
}