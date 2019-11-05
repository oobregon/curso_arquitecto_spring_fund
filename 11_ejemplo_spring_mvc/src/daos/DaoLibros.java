package daos;

import java.util.List;
import model.Libro;

public interface DaoLibros {
	List<Libro> obtenerLibros();
	List<Libro> obtenerLibrosPorTema(int idTema);
}
