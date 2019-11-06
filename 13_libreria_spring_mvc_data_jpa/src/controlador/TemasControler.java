package controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import daos.DaoTemas;
import model.Tema;
import spdatajpa.DaoLibros;

@Controller
public class TemasControler {
	@Autowired
	DaoTemas daoTemas;
		
	@Autowired
	DaoLibros daoLibros;
	
	@GetMapping(value="aTemas" )
	public String iniciar(Model model) {
		List<Tema> temas = daoTemas.obtenerTemas();
		Tema tema = new Tema();
		model.addAttribute("temas",temas);		
		model.addAttribute("tema",tema);
		return "temas";
	}		
}
