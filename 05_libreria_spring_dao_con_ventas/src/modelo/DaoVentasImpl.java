package modelo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javabeans.Libro;

@Repository (value = "daoVentasImplUno")
public class DaoVentasImpl implements DaoVentas {
	@Autowired
	JdbcTemplate accDatos;
	
	// Hay 5 libros, se llevan insertados 3 y se produce una excepción. ¿Qué ocurre si se insertan 3 y
	// ¿Cómo conseguimos que si falla una de las inserciones se deshagan todas las operaciones? 
	// Mediante el objeto TransactionManager
	// @Transactional no es inyección de dependencias. Lo que estamos diciendo es que se aplique a este método
	// las características asociadas a dicha anotación. En este concepto subyace la programación orientada a aspectos,
	// es decir, funcionalidad transversal, funcionalidad que se puede aplicar a lo largo de toda la aplicación. 
	@Transactional
	@Override
	public void agregarVentas(List<Libro> libros,int idCliente) {
		String sql = "insert into ventas (idCliente,idLibro,fecha) values (?,?,?) ";
		Date fecha = new Date();
		for(Libro libro:libros) {
			accDatos.update(sql,idCliente,libro.getIsbn(),fecha);
		}		
	}	
}
