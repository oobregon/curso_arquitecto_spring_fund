package managed;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import daos.DaoLibros;
import model.Libro;
import utilidades.ContextoApp;

// No ser�a necesario a�ada la anotaci�n (name = "librosBean"), ya que, por defecto se crear�a con ese nombre, 
// es decir, el nombre de la clase pero empezando por min�scula
@ManagedBean(name = "librosBean")
@RequestScoped
public class LibrosBean {
	private List<Libro> libros;
	
	// Por propia definici�n, la inyecci�n de dependencia es que inyectamos un objeto (EJB) en otro (LibrosBean), pero claro,
	// LibrosBean ya tiene que estar creado; sino est� creado el LibrosBean, entonces �D�nde inyectas el EJB?
	// Durante la creaci�n de LibrosBean no se puede hacer inyecci�n de dependencias porque todav�a no existe el objeto que va a recibir la inyecci�n.
	// Por regla general, la mejor soluci�n a este problema es la anotaci�n @PostConstruct 
	@ManagedProperty("#{daoLib}")
	DaoLibros daoLib;
	
	// Podemos inyectar el loginBean porque su �mbito es de sesi�n, si su �mbito fuera de petici�n, en este punto no podr�amos 
	// inyectar dicho managedBean porque ya no existir�a
	
	public DaoLibros getDaoLib() {
		return daoLib;
	}

	public void setDaoLib(DaoLibros daoLib) {
		this.daoLib = daoLib;
	}

	@ManagedProperty("#{temasBean}")
	TemasBean temasBean;	
	
	public LibrosBean() {}

	private void cargaLibros() {		
		int idTema = temasBean.getIdTema();
		libros = idTema==0?daoLib.obtenerLibros():daoLib.obtenerLibrosPorTema(idTema);		
	}

	public List<Libro> getLibros() {
		this.cargaLibros();
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public TemasBean getTemasBean() {
		return temasBean;
	}

	public void setTemasBean(TemasBean temasBean) {
		this.temasBean = temasBean;
	}
	
	public String cerrarSesion() {		
		// FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		ContextoApp.obtenerSesion().invalidate();
		return "login";
	}
}
