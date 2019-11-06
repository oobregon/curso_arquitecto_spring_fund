package controlador;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import daos.DaoVentas;
import model.Cliente;
import model.Venta;

@Controller
public class VentasController {
	
	@Autowired
	DaoVentas daoV;
	
	@GetMapping(value = "aVentas")        
	public String inicio(HttpSession sesion,Model model) {
		Cliente usuario = (Cliente)sesion.getAttribute("clienteLogado");
		List<Venta> ventas = daoV.obtenerVentasCliente(usuario.getIdCliente());
		model.addAttribute("ventasPorCliente",ventas);
		return "ventas";
	}
}
