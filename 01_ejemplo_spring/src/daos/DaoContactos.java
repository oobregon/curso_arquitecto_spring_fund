package daos;

import java.util.List;

import model.Contacto;

public interface DaoContactos {

	void altaContacto();

	void eliminarContacto(int idContacto);

	void altaContacto(Contacto contacto);

	void altaContactoParametrizado(Contacto contacto);

	List<Contacto> dameContactos();

}