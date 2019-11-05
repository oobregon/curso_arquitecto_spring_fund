package controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import daos.DaoClientes;
import model.Cliente;

@Controller
public class RegistroController {
	@Autowired
	DaoClientes daoCliente;
	
	@PostMapping (value = "/registrar")
	public String registrar(@RequestParam("user") String nombre,
			@RequestParam("pwd") String contra,
			@RequestParam("email") String email,
			@RequestParam("telefono") int telefono) {
		Cliente cliente = new Cliente(0,email,contra,telefono,nombre);
		daoCliente.registrar(cliente);
		return "login";
	}
}
