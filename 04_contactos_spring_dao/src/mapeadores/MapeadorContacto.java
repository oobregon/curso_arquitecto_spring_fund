package mapeadores;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.Contacto;

public class MapeadorContacto implements RowMapper<Contacto> {

	@Override
	public Contacto mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contacto contacto = new Contacto();
		contacto.setIdContacto(rs.getInt("idContacto"));
		contacto.setNombre(rs.getString("nombre"));
		contacto.setEmail(rs.getString("email"));
		contacto.setEdad(rs.getInt("edad"));
		return contacto;
	}	
}
