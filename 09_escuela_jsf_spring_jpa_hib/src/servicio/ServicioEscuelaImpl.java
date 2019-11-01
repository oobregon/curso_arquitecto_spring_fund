package servicio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DaoAlumnos;
import dao.DaoCursos;
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
	public void matricular(Alumno alumno) {
		if (daoAlum.findAlumnoByDni(alumno.getDni()) == null) {
			daoAlum.saveAlumno(alumno);
		}
	}

	@Transactional
	@Override
	public void eliminarCurso(int idCurso) {		
		List<Alumno> alumnos = daoAlum.findAlumnosByCurso(idCurso);
		daoCur.removeCurso(idCurso);
		for(Alumno al : alumnos) {
			daoAlum.removeAlumno(al.getDni());
		}
	}

	@Override
	public List<Curso> filtrarCursosPorFecha(Date fecha) {
		return daoCur.findAllCursosByFecha(fecha);
	}
}