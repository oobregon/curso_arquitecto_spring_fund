package servicio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dao.DaoAlumnos;
import dao.DaoCursos;
import dto.CursoView;
import model.Alumno;
import model.Curso;

@Service (value = "capaServEscuela")
public class ServicioEscuelaImpl implements ServicioEscuela {
	
	@Autowired
	DaoAlumnos daoAlum;
	
	@Autowired
	DaoCursos daoCur;

	@Transactional
	@Override
	public void matricular(Alumno alumno,int idCurso) {		
		if (daoAlum.findAlumnoByDni(alumno.getDni()) == null) {
			Curso curso = this.obtenerCursoPorId(idCurso);
			alumno.setCurso(curso);
			daoAlum.saveAlumno(alumno);
		}
	}

	@Transactional
	@Override
	public void eliminarCurso(int idCurso) {		
		List<Alumno> alumnos = daoAlum.findAlumnosByCurso(idCurso);		
		for(Alumno al : alumnos) {
			daoAlum.removeAlumno(al.getDni());
		}
		daoCur.removeCurso(idCurso);		
	}

	@Override
	public List<Curso> filtrarCursosPorFecha(Date fecha) {
		return daoCur.findAllCursosByFecha(fecha);
	}

	@Override
	public List<Object[]> obtenerInfoTablaCursosPorFecha(Date fecha) {
		return daoCur.obtenerCursosConteoAlumnos(fecha);
	}

	@Override
	public List<Curso> obtenerTodosCursos() {
		return daoCur.findAllCursos();
	}

	@Override
	public Curso obtenerCursoPorId(int idCurso) {
		return daoCur.findCursoById(idCurso);
	}

	@Override
	public void registrarCurso(Curso curso) {
		daoCur.persistByEntity(curso);
	}
	
	@Override
	public List<CursoView> obtenerCursosFecha(Date fecha) {
		List<Curso> cursos = this.filtrarCursosPorFecha(fecha);
		List<CursoView> cursosView = new ArrayList<CursoView>();
		for (Curso curso : cursos) {			
			// Método uno, acoplamiento por uso de las relaciones JPA en la capa de servicio. Este acoplamiento sería permisible en la capa DAO, que es el lugar adecuado para 
			// acoplarnos a la tecnología de acceso a datos, pero en la capa de servicio tenemos que minimizar el acoplamiento a la tecnología de acceso a datos.
			// CursoView cursoView = new CursoView(curso,curso.getAlumnos().size());
			
			// Método dos, no hay acomplamiento con la tecnología de acceso a datos, pero hemos tenido que crear un método específico para obtener el número 
			// de alumnos de un curso; hay que llamar a este método por cada curso
			CursoView cursoView = new CursoView(curso,daoCur.findNumAlumnosByCurso(curso.getIdCurso()));
			cursosView.add(cursoView);
		}
		return cursosView;
	}
}