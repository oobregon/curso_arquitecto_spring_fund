package managed;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import model.Curso;
import servicio.ServicioEscuela;

@ManagedBean(name = "cursosBean")
@ViewScoped
public class CursosBean {
	private Date fechaInicio;
	private List<Curso> cursos;
	private List<Object[]> infoCursos;
	
	@ManagedProperty("#{capaServEscuela}")
	ServicioEscuela capaServ;
	
	private void cargarCursos() {
		//setCursos(capaServ.findAllCursos());
		setInfoCursos(capaServ.obtenerInfoTablaCursosPorFecha(getFechaInicio()));
	}
	
	public void verCursos() {				
		this.cargarCursos();
	}
	
	public void eliminarCurso(int idCurso) {				
		capaServ.eliminarCurso(idCurso);
		this.cargarCursos();
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public ServicioEscuela getCapaServ() {
		return capaServ;
	}

	public void setCapaServ(ServicioEscuela capaServ) {
		this.capaServ = capaServ;
	}

	public List<Object[]> getInfoCursos() {
		return infoCursos;
	}

	public void setInfoCursos(List<Object[]> infoCursos) {
		this.infoCursos = infoCursos;
	}
}
