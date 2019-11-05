package controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import daos.DaoLibros;
import daos.DaoTemas;
import model.Libro;
import model.Tema;

@Controller
public class TemasControler {
	@Autowired
	DaoTemas daoTemas;
	
	@Autowired
	DaoLibros daoLibros;
	
	@GetMapping(value="aTemas")
	public String iniciar(Model model) {
		List<Tema> temas = daoTemas.obtenerTemas();
		Tema tema = new Tema();
		model.addAttribute("temas",temas);		
		model.addAttribute("tema",tema);
		return "temas";
	}
	
	// Este 
	@PostMapping (value = "/libros")
	public String mostrarLibros(@ModelAttribute("tema") Tema tema,Model model) {		
		List<Libro> libros = daoLibros.obtenerLibrosPorTema(tema.getIdTema());
		model.addAttribute("libros",libros); 
		return "libros";
	}
}
