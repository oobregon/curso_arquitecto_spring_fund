package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import model.Alumno;
import model.Curso;
import servicio.ServicioEscuela;

@ManagedBean (name = "altaAlumnoBean")
@RequestScoped
public class AltaAlumnoBean {
	private int idCursoSelecc;
	private Alumno alumno;
	private List<Curso> cursos;
	
	@ManagedProperty("#{capaServEscuela}")
	ServicioEscuela capaServ;
	
	@PostConstruct
	private void cargarCursos() {
		setCursos(getCapaServ().obtenerTodosCursos());
		setAlumno(new Alumno());		
	}
	
	public String crearAlumno() {
		Curso curso = getCapaServ().obtenerCursoPorId(getIdCursoSelecc());
		getAlumno().setCurso(curso);
		getCapaServ().matricular(getAlumno());		
		return "inicio";
	}
	
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public int getIdCursoSelecc() {
		return idCursoSelecc;
	}

	public void setIdCursoSelecc(int idCursoSelecc) {
		this.idCursoSelecc = idCursoSelecc;
	}

	public ServicioEscuela getCapaServ() {
		return capaServ;
	}

	public void setCapaServ(ServicioEscuela capaServ) {
		this.capaServ = capaServ;
	}
}
