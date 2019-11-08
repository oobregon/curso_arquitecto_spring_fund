package controlador;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import service.ServicioCajero;

@Controller
public class AccesoController {
	@Autowired
	ServicioCajero sCajero;
	
	
	@PostMapping (value = "/login")
	public String validarCuenta(@RequestParam("numCuenta") int numCuenta,HttpSession sesion) {		
		if (sCajero.obtenerCuenta(numCuenta) != null) {			
			sesion.setAttribute("cuentaAutenticada",numCuenta);			
			return "operaciones";
		} else {
			return "login";
		}
	}
	
	@PostMapping (value = "/transferencia")
	public String hacerTransferencia(@RequestParam("cuentaDestino") int numCuentaDestino,
							   @RequestParam("cantidad") String cantidad,
							   @SessionAttribute("cuentaAutenticada") int numCuentaOrigen) {		
		sCajero.transferir(numCuentaOrigen, numCuentaDestino,Double.parseDouble(cantidad));
		return "operaciones";
	}	
}
