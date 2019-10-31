package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import daos.DaoTemas;
import model.Tema;

@ManagedBean(name = "temasBean")
@RequestScoped
public class TemasBean {
	private int idTema;
	private List<Tema> temas;

	@ManagedProperty("#{daoTemas}")
	DaoTemas daoTemas;	
	
	@PostConstruct
	private void cargaTemas() {
		temas = daoTemas.obtenerTemas();
	}

	public int getIdTema() {
		return idTema;
	}

	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}
	
	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}
	
	// No merece la pena tener un m�todo de accion, cuya �nica misi�n es 
	public String mostrarLibros() {
		return "libros";
	}

	public DaoTemas getDaoTemas() {
		return daoTemas;
	}

	public void setDaoTemas(DaoTemas daoTemas) {
		this.daoTemas = daoTemas;
	}	
}
