package controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import daos.DaoClientes;
import model.Cliente;

@Controller
public class RegistroController {
	@Autowired
	DaoClientes daoCliente;
	
	// Model es un objeto de Spring en el que se guarda el javabean al que se vuelcan los valores de los componentes html,
	// es decir, es un mapeo que va a usar en el controlador. El �mbito del objeto Model es mayor que el de Petici�n 
	// pero menor que el de sesi�n. No deber�amos usar este objeto Model para guardar par�metros de petici�n ni se sesi�n. 
	// Antes de llegar a la pagina registro, creamos un objeto Cliente vac�o.
	// Este metodo se ejecuta cuando se pulsa el hipervinculo que nos lleva a la pagina registro.
	// Prepara el objeto Cliente. Este metodo se ejecuta antes de que se cargue el formulario a donde se dirige, en este caso registro
	@GetMapping(value="toRegistro")
	public String iniciar(Model model) {
		Cliente c = new Cliente();
		model.addAttribute("cliente",c);
		return "registro";
	}

	// Este 
	@PostMapping (value = "/registrar")
	public String registrar(@ModelAttribute("cliente") Cliente cliente) {		
		daoCliente.registrar(cliente);
		return "login";
	}
}
