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
		if (!daoAlum.existsById(alumno.getDni())) {
			Curso curso = this.obtenerCursoPorId(idCurso);			
			alumno.setCurso(curso);
			daoAlum.save(alumno);			
		}
	}

	@Transactional
	@Override
	public void eliminarCurso(int idCurso) {		
		List<Alumno> alumnos = daoAlum.findAlumnosByCurso(idCurso);		
		for(Alumno al : alumnos) {
			daoAlum.deleteById(al.getDni());
		}
		daoCur.deleteById(idCurso);		
	}

	private List<Curso> filtrarCursosPorFecha(Date fecha) {
		return daoCur.findByFechaInicio(fecha);
	}

	@Override
	public List<Curso> obtenerTodosCursos() {
		return daoCur.findAll();
	}

	@Override
	public Curso obtenerCursoPorId(int idCurso) {
		return daoCur.getOne(idCurso);
	}

	@Transactional
	@Override
	public void registrarCurso(Curso curso) {
		daoCur.save(curso);
	}	
	
	@Override
	public List<CursoView> obtenerCursosPorFecha(Date fecha) {
		List<Curso> cursos = this.filtrarCursosPorFecha(fecha);
		List<CursoView> cursosView = new ArrayList<CursoView>();
		for (Curso curso : cursos) {			
			// Método uno, acoplamiento por uso de las relaciones JPA en la capa de servicio. Este acoplamiento sería permisible en la capa DAO, que es el lugar adecuado para 
			// acoplarnos a la tecnología de acceso a datos, pero en la capa de servicio tenemos que minimizar el acoplamiento a la tecnología de acceso a datos.
			// CursoView cursoView = new CursoView(curso,curso.getAlumnos().size());
			
			// Método dos, no hay acomplamiento con la tecnología de acceso a datos, pero hemos tenido que crear un método específico para obtener el número 
			// de alumnos de un curso; hay que llamar a este método por cada curso
			CursoView cursoView = new CursoView(curso,daoAlum.findNumAlumnosByCurso(curso.getIdCurso()));
			cursosView.add(cursoView);
		}
		return cursosView;
	}
}