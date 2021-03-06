package controlador;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import model.Venta;
import servicio.CapaServicio;

@Controller
public class VentasController {
	
	@Autowired
	CapaServicio serv;
	
	// En este metodo, en lugar de obtener el objeto sesion, tenemos otra opci�n y es pedir a spring
	// que nos inyecte el valor de un atributo de sesion.
	// Asimismo, en lugar de guardar la lista de ventas en el objeto model, lo vamos a guardar en 
	// un objeto de peticion.
	@GetMapping(value = "/aVentas")        
	public String inicio(HttpServletRequest req) {		
		List<Venta> ventas = serv.obtenerVentasCliente(1);
		req.setAttribute("ventasPorCliente",ventas);		
		return "ventas";
	}
}
