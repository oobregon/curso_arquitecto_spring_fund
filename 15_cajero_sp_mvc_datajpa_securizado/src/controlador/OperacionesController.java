package controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import model.Cuenta;
import service.ServicioCajero;

@Controller
public class OperacionesController {
	@Autowired
	ServicioCajero sCajero;
	
	@PostMapping(value = "/ingreso")
	public String ingresar(@SessionAttribute("cuentaAutenticada") Cuenta cuenta,
						   @RequestParam("cantidad") String cantidad) {
		sCajero.ingresar(cuenta.getNumeroCuenta(),Double.parseDouble(cantidad));
		return "operaciones";
	}
}
