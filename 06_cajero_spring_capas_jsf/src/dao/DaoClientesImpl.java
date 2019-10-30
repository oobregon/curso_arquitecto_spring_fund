package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Cliente;

@Repository
public class DaoClientesImpl implements DaoClientes {	
	@Autowired
	JdbcTemplate accDatos;
	
	@Override
	public List<Cliente> findClienteByCuenta(int idCuenta) {
		String sql = "select cli.* from clientes cli inner join titulares tit on cli.dni = tit.idCliente where tit.idCuenta = ?";
		return accDatos.query(sql,(rs,fila) -> new Cliente(rs.getInt("dni"),
													rs.getString("direccion"),
													rs.getString("nombre"),
													rs.getInt("telefono")),idCuenta);			
	}

	@Override
	public void saveCliente(Cliente cliente) {
		String sql="insert into clientes (dni,nombre,direccion,telefono) values (?,?,?,?)";
		accDatos.update(sql,cliente.getDni(),cliente.getNombre(),cliente.getDireccion(),cliente.getTelefono());
	}

	@Override
	public void updateCliente(Cliente cliente) {		
		String sql = "update clientes set nombre = ?, direccion = ?, telefono = ? where dni = ?";
		accDatos.update(sql,cliente.getNombre(),cliente.getDireccion(),cliente.getTelefono(),cliente.getDni());
	}

	@Override
	public void removeCliente(int dni) {
		String sql = "delete from clientes where dni = ?";
		accDatos.update(sql,dni);		
	}
}