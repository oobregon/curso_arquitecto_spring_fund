package daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Cliente;
import model.Venta;

public interface DaoVentas extends JpaRepository<Venta,Integer> {
	
	public List<Venta> obtenerVentasCliente(int idCliente);
	public List<Venta> obtenerVentasLibro(int isbn);
}
