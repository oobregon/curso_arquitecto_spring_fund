package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import model.Cuenta;
import service.ServicioCajero;

@Controller
public class OperacionesController {
	@Autowired
	ServicioCajero sCajero;
	
	@PostMapping(value = "/ingreso")
	public String ingresar(@SessionAttribute("cuentaAutenticada") Cuenta cuenta,
						   @RequestParam("cantidad") String cantidad,
						   HttpSession sesion) {
		sCajero.ingresar(cuenta.getNumeroCuenta(),Double.parseDouble(cantidad));
		Cuenta cuentaActualizada = sCajero.obtenerCuenta(cuenta.getNumeroCuenta());		
		sesion.setAttribute("cuentaAutenticada",cuentaActualizada);
		return "operaciones";
	}
	
	@PostMapping(value = "/extraccion")
	public String extraer(@SessionAttribute("cuentaAutenticada") Cuenta cuenta,
						  @RequestParam("cantidad") String cantidad,
						   HttpSession sesion) {
		sCajero.extraer(cuenta.getNumeroCuenta(),Double.parseDouble(cantidad));
		Cuenta cuentaActualizada = sCajero.obtenerCuenta(cuenta.getNumeroCuenta());		
		sesion.setAttribute("cuentaAutenticada",cuentaActualizada);
		return "operaciones";
	}
	
	
	@PostMapping (value = "/transferencia")
	public String transferir(@RequestParam("cuentaDestino") int numCuentaDestino,
			   				 @RequestParam("cantidad") String cantidad,
   							 @SessionAttribute("cuentaAutenticada") Cuenta cuenta,
   							 HttpSession sesion) {
		sCajero.transferir(cuenta.getNumeroCuenta(), numCuentaDestino,Double.parseDouble(cantidad));
		Cuenta cuentaActualizada = sCajero.obtenerCuenta(cuenta.getNumeroCuenta());		
		sesion.setAttribute("cuentaAutenticada",cuentaActualizada);
		return "operaciones";
	}
	
	@GetMapping (value = "/movimientos")
	public String mostrarMovimientos(@SessionAttribute("cuentaAutenticada") Cuenta cuenta,
									 HttpServletRequest req) {
		req.setAttribute("movimientos",sCajero.obtenerMovimientos(cuenta.getNumeroCuenta()));
		return "movimientos";
	}
	
	@GetMapping (value = "/aCambioDeCuenta")
	public String cambiarDeCuenta(@RequestParam("cuenta") int numCuenta,
								  HttpSession sesion) {
		Cuenta cuenta = sCajero.obtenerCuenta(numCuenta);
		sesion.setAttribute("cuentaAutenticada",cuenta);
		return "operaciones";
	}
	
	@GetMapping (value = "/cambiarCuentaPorAjax")
	public void cambiarDeCuentaPorAjax(@RequestParam("cuenta") int numCuenta,
									   HttpSession sesion,	
									   HttpServletResponse response) throws IOException {
		Cuenta cuenta = sCajero.obtenerCuenta(numCuenta);
		sesion.setAttribute("cuentaAutenticada",cuenta);
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		out.println(convertirJson(cuenta));
	}
	
	
	private String convertirJson(Cuenta cuenta) {
		JSONArray array=new JSONArray();
		JSONObject obj=new JSONObject();
		obj.put("numeroCuenta",cuenta.getNumeroCuenta());
		obj.put("saldo",cuenta.getSaldo());		
		array.add(obj);
		return array.toJSONString();
	}
	
}
