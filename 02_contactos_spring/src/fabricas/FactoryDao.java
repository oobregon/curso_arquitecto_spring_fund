package fabricas;

import daos.DaoContactos;
import daos.DaoContactosImpl;

// Implementa el patr�n factory
// F�brica modificada
public class FactoryDao {
	public static DaoContactos obtenerDaoContactos() {
		return new DaoContactosImpl();
	}
}
