package daos;

import java.util.List;
import model.Venta;

public interface DaoVentas {
	public List<Venta> obtenerVentasCliente(int idCliente);
	public List<Venta> obtenerVentasLibro(int isbn);
}
