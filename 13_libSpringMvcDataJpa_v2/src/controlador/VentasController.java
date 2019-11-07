package controlador;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import model.Cliente;
import model.Venta;
import servicio.CapaServicio;

@Controller
public class VentasController {
	
	@Autowired
	CapaServicio serv;
	
	// En este metodo, en lugar de obtener el objeto sesion, tenemos otra opción y es pedir a spring
	// que nos inyecte el valor de un atributo de sesion.
	// Asimismo, en lugar de guardar la lista de ventas en el objeto model, lo vamos a guardar en 
	// un objeto de peticion.
	@GetMapping(value = "aVentas")        
	public String inicio(@SessionAttribute("clienteLogado") Cliente usuario,HttpServletRequest req) {		
		List<Venta> ventas = serv.obtenerVentasCliente(usuario.getIdCliente());
		req.setAttribute("ventasPorCliente",ventas);		
		return "ventas";
	}
	
	@GetMapping(value = "aNada")        
	public String inicioVersionDos(HttpSession sesion,Model model) {
		Cliente usuario = (Cliente)sesion.getAttribute("clienteLogado");
		List<Venta> ventas = serv.obtenerVentasCliente(usuario.getIdCliente());
		model.addAttribute("ventasPorCliente",ventas);
		return "ventas";
	}
}
