package daos;

import java.util.List;

import javax.ejb.Local;

import model.Contacto;

@Local
public interface DaoContactos {
	List<Contacto> dameContactos();
	
	List<Contacto> dameContactosPorNombre(String nombre);
	
	Contacto dameContacto(String email);

	void altaContactoParametrizado(Contacto contacto);

	void eliminarContacto(int idContacto);
}
