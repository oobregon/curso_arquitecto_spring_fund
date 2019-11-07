package controlador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import model.Cliente;
import servicio.CapaServicio;

@Controller
public class LoginController {
	@Autowired
	CapaServicio serv;
	
	
	// Spring, inyectame un parámetro, inyectame una cookie, lo que sea, por eejmpl, quiero solo el objeto HttpServletRequest
	// @PostMapping: Esto signfica que este método esta asociado a una petición POST
	@PostMapping (value = "/login")
	public String login(@RequestParam("user") String usuario,
						@RequestParam("pwd") String contra,HttpSession sesion) {
		Cliente cliLogado = serv.obtenerCliente(usuario,contra);
		if (cliLogado != null) {			
			sesion.setAttribute("clienteLogado",cliLogado);			
			return "bienvenida";
		} else {
			return "error";
		}		
	}
	
	// Spring, inyectame un parámetro, inyectame una cookie, lo que sea, por eejmpl, quiero solo el objeto HttpServletRequest
	// @PostMapping: Esto signfica que este método esta asociado a una petición POST
	@PostMapping (value = "/verReq")
	public String verHttpReq(HttpServletRequest req) {
		return "seguimos";		
	}
		
	// Spring, inyectame un parámetro, inyectame una cookie, lo que sea, por eejmpl, quiero solo el objeto HttpServletRequest
	// @PostMapping: Esto signfica que este método esta asociado a una petición POST
		@PostMapping (value = "/verSess")
	public String verObjetoSesion(@SessionAttribute("objSesion") String atrSesion) {
		return "seguimos";		
	}
}



