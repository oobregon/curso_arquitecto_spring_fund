package fabricas;

import daos.DaoContactos;
import daos.DaoContactosImpl;

// Implementa el patrón factory
// Fábrica modificada
public class FactoryDao {
	public static DaoContactos obtenerDaoContactos() {
		return new DaoContactosImpl();
	}
}
