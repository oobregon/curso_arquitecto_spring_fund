package controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import model.Cliente;
import servicio.CapaServicio;

@Controller
public class RegistroController {
	@Autowired
	CapaServicio serv;
	
	// Model es un objeto de Spring en el que guardar los JavaBeans en los que volcamos los datos de un formulario.
	// pero su �mbito es mayor que el de Petici�n pero menor que el de sesi�n 
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
		serv.registrar(cliente);
		return "login";
	}
}
