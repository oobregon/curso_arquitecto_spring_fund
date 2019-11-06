package servicio;

import java.util.List;

import model.Cliente;
import model.Libro;
import model.Tema;
import model.Venta;

public interface CapaServicio {
	public boolean estaRegistrado(String usuario,String contra);
	public Cliente obtenerCliente(String usuario,String contra);
	public List<Libro> obtenerLibrosPorTema(int idTema);
	public void registrar(Cliente cliente);
	public List<Tema> obtenerTemas();
	public List<Venta> obtenerVentasCliente(int idCliente);	
}
