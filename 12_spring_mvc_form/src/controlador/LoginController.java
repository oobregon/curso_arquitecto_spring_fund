package controlador;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import daos.DaoClientes;

@Controller
public class LoginController {
	@Autowired
	DaoClientes daoCliente;
	
	
	// Spring, inyectame un par�metro, inyectame una cookie, lo que sea, por eejmpl, quiero solo el objeto HttpServletRequest
	// @PostMapping: Esto signfica que este m�todo esta asociado a una petici�n POST
	@PostMapping (value = "/login")
	public String login(@RequestParam("user") String usuario,
						@RequestParam("pwd") String contra) {
		if (daoCliente.existe(usuario,contra)) {
			return "bienvenida";
		} else {
			return "error";
		}		
	}
	
	// Spring, inyectame un par�metro, inyectame una cookie, lo que sea, por eejmpl, quiero solo el objeto HttpServletRequest
	// @PostMapping: Esto signfica que este m�todo esta asociado a una petici�n POST
	@PostMapping (value = "/verReq")
	public String verHttpReq(HttpServletRequest req) {
		return "seguimos";		
	}
		
	// Spring, inyectame un par�metro, inyectame una cookie, lo que sea, por eejmpl, quiero solo el objeto HttpServletRequest
	// @PostMapping: Esto signfica que este m�todo esta asociado a una petici�n POST
		@PostMapping (value = "/verSess")
	public String verObjetoSesion(@SessionAttribute("objSesion") String atrSesion) {
		return "seguimos";		
	}
}



