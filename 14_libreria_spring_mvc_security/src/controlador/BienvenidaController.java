package controlador;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import model.Cliente;
import servicio.CapaServicio;

@Controller
public class BienvenidaController {
	
	 @Autowired
	 CapaServicio sLib;
	
	@GetMapping("/aBienVenida")
	public String iniciarBienvenida(HttpSession sesion) {
		Cliente usuario = sLib.obtenerCliente("test1","test1"); 
		sesion.setAttribute("clienteLogado",usuario);
		return "bienvenida";
	}
}
