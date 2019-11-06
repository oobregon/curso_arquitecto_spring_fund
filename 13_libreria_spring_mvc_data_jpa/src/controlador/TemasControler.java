package controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import model.Tema;
import servicio.CapaServicio;

@Controller
public class TemasControler {
	@Autowired
	CapaServicio serv;
	
	@GetMapping(value="aTemas" )
	public String iniciar(Model model) {
		List<Tema> temas = serv.obtenerTemas();
		Tema tema = new Tema();
		model.addAttribute("temas",temas);		
		model.addAttribute("tema",tema);
		return "temas";
	}		
}
