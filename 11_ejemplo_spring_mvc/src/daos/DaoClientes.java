package daos;

import java.util.List;
import model.Cliente;

public interface DaoClientes {
	
	boolean existe(String user, String pass);		
	Cliente obtenerCliente(String user, String pass);	
	Cliente obtenerClientePorId(int idCliente);
	List<Cliente> obtenerClientes();
	void registrar(Cliente c);	
	void actualizar(Cliente c);
	void eliminar(int idCliente);
}
