package managed;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import model.Curso;
import servicio.ServicioEscuela;

@ManagedBean (name = "altaCursoBean")
@RequestScoped
public class AltaCursoBean {
	private Curso curso;
	
	@ManagedProperty ("#{capaServEscuela}")
	ServicioEscuela capaServ;
	
	@PostConstruct
	private void inicio() {
		setCurso(new Curso());
	}
	
	public String registrarCurso() {
		getCapaServ().registrarCurso(getCurso());
		return "cursos";
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public ServicioEscuela getCapaServ() {
		return capaServ;
	}

	public void setCapaServ(ServicioEscuela capaServ) {
		this.capaServ = capaServ;
	}
	
}
