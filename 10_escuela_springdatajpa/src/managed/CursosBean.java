package managed;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import dto.CursoView;
import model.Curso;
import servicio.ServicioEscuela;

@ManagedBean(name = "cursosBean")
@ViewScoped
public class CursosBean {
	private Date fechaInicio;
	private List<Curso> listaCursos;
	
	@ManagedProperty("#{capaServEscuela}")
	ServicioEscuela capaServ;
	
	private void cargarCursos() {
		//setListaCursos(getCapaServ().obtenerCursosFecha(getFechaInicio()));
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

	public ServicioEscuela getCapaServ() {
		return capaServ;
	}

	public void setCapaServ(ServicioEscuela capaServ) {
		this.capaServ = capaServ;
	}

	public List<Curso> getListaCursos() {
		return listaCursos;
	}

	public void setListaCursos(List<Curso> listaCursos) {
		this.listaCursos = listaCursos;
	}
}
