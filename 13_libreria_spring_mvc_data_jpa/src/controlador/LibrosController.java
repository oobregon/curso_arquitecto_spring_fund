package controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import model.Libro;
import model.Tema;
import servicio.CapaServicio;
import spdatajpa.DaoLibros;

@Controller
public class LibrosController {
	
	@Autowired
	CapaServicio serv;
	
	@PostMapping (value = "/obtenerListaLibros")
	public String prepararListaLibros(@ModelAttribute("tema") Tema tema,Model model) {	
		model.addAttribute("tema",tema);
		List<Libro> libros = serv.obtenerLibrosPorTema(tema.getIdTema());
		model.addAttribute("libros",libros);
		return "libros"; 
	}
}
