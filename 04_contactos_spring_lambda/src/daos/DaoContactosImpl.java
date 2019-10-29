package daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Contacto;

// Este value es un id que sirve para hacer referencia a él desde la capa de servicio.
@Repository (value = "daoContImplUno")
public class DaoContactosImpl implements DaoContactos {	
	@Autowired
	JdbcTemplate accDatos;
	
	@Override
	public void altaContacto() {
		String sql = "insert into contactos (nombre,email,edad) values(";
		sql+="'jdbc','jdbc@gmail.com',34)";
		accDatos.update(sql);		
	}
	
	@Override
	public void eliminarContacto(int idContacto) {
		String sql = "delete from contactos where idContacto = ?";
		accDatos.update(sql,idContacto);
	}
	
	
	@Override
	public void altaContacto(Contacto contacto) {
		String sql = "insert into contactos (nombre,email,edad) values";
		sql+="('" + contacto.getNombre() +"','" + contacto.getEmail() + "'," + contacto.getEdad() + ")";
		accDatos.update(sql);
	}
	
	
	@Override
	public void altaContactoParametrizado(Contacto contacto) {
		String sql = "insert into contactos (nombre,email,edad) values (?,?,?)";
		accDatos.update(sql,contacto.getNombre(),contacto.getEmail(),contacto.getEdad());		
	}
	
	@Override
	public List<Contacto> dameContactos() {
		String sql = "select idContacto,nombre,email,edad from contactos";
		
		// Expresión lambda. Implementación del método mapRow de la interface 
		return accDatos.query(sql, (rs,fila) -> new Contacto(rs.getInt("idContacto"),
				rs.getString("nombre"),
				rs.getString("email"),
				rs.getInt("edad")));	
	}	
}
