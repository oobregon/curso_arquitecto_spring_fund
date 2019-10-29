package modelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javabeans.Cliente;

@Repository (value = "daoClienImplUno")
public class DaoClientesImpl implements DaoClientes {
	@Autowired
	JdbcTemplate accDatos;	
	
	@Override
	public boolean autenticar(String user, String pass) {
		String sql = "select * from clientes where usuario=? and password=?";
		return accDatos.query(sql,(rs,fila) -> new Cliente(rs.getInt("idCliente"),rs.getString("usuario"),
				                                           rs.getString("password"),rs.getString("email"),rs.getInt("telefono"))
				              ,user,pass).size() > 0;		
	}

	@Override
	public void registrar(Cliente c) {
		String sql="insert into contactos (usuario,password,email,telefono) ";
        sql+="values(?,?,?,?)";
        accDatos.update(sql,c.getUsuario(),c.getPassword(),c.getEmail(),c.getTelefono());		 		
	}
}
