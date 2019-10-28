package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoContactos;
import fabricas.FactoryDao;
import model.Contacto;

/**
 * Servlet implementation class EliminarAction.  Los controladores de accion forman parte del Controlador (Patrón MVC)
 */
@WebServlet("/EliminarAction")
public class EliminarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		int idContacto = Integer.parseInt(request.getParameter("idContacto"));		 		
		DaoContactos dao = FactoryDao.obtenerDaoContactos();
		dao.eliminarContacto(idContacto);	
		request.setAttribute("resultado","ok");
	}
}
