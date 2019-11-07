package controlador;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	public String iniciar(Model model,HttpServletRequest req) {		
		Tema tema = new Tema();
		model.addAttribute("Tema",tema);						
		this.asigTemasAttrPet(req);
		return "temas";
	}
	
	@PostMapping(value="aTemas" )
	public String recargar(Model model,HttpServletRequest req) {
		this.asigTemasAttrPet(req);			
		return "temas";
	}
	
	@PostMapping (value = "/obtenerListaLibros")
	public String prepararListaLibros(@ModelAttribute("tema") Tema tema,
			                          Model model,HttpServletRequest req) {	
		model.addAttribute("Tema",tema);
		List<Libro> libros = serv.obtenerLibrosPorTema(tema.getIdTema());
		req.setAttribute("libros",libros);		
		return "forward:/aTemas"; 
	}
	
	private void asigTemasAttrPet(HttpServletRequest req) {
		List<Tema> temas = serv.obtenerTemas();
		req.setAttribute("temas",temas);
	}
}
