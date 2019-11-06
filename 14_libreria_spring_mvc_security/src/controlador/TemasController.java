package controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import model.Libro;
import model.Tema;
import servicio.CapaServicio;

@Controller
public class TemasController {
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
	
	@PostMapping (value = "/obtenerListaLibros")
	public String prepararListaLibros(@ModelAttribute("tema") Tema tema,Model model) {	
		model.addAttribute("tema",tema);
		List<Libro> libros = serv.obtenerLibrosPorTema(tema.getIdTema());
		model.addAttribute("libros",libros);
		return "libros"; 
	}
}
