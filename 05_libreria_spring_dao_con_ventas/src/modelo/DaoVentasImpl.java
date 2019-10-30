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
	
	// Hay 5 libros que se tienen que insertar; empieza la ejecuci�n del m�todo, y cuando ya se han insertado 3 se produce una excepci�n. 
	// �Qu� ocurre ahora? �Se quedan insertados esos 3 y los otros 2 no? �Se rechaza la inserci�n de esos 3?
	// �C�mo conseguimos que si falla una de las inserciones se deshagan todas las operaciones? 
	// Mediante el objeto TransactionManager
	// @Transactional no es inyecci�n de dependencias. Lo que estamos diciendo es que se aplique a este m�todo
	// las caracter�sticas asociadas a dicha anotaci�n. En este concepto subyace la programaci�n orientada a aspectos,
	// es decir, funcionalidad transversal, funcionalidad que se puede aplicar a lo largo de toda la aplicaci�n. 
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
