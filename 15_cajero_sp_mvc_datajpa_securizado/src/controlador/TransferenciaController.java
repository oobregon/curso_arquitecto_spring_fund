package controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import model.Cuenta;
import service.ServicioCajero;

@Controller
public class TransferenciaController {
	@Autowired
	ServicioCajero sCajero;
	
	@PostMapping (value = "/transferencia")
	public String realizarTransferencia(@RequestParam("cuentaDestino") int numCuentaDestino,
			   							@RequestParam("cantidad") String cantidad,
   										@SessionAttribute("cuentaAutenticada") Cuenta cuenta) {
		sCajero.transferir(cuenta.getNumeroCuenta(), numCuentaDestino,Double.parseDouble(cantidad));
		return "forward:aOperaciones";
	}
}
