package dao;

import java.util.List;

import model.Alumno;

public interface DaoAlumnos {
	List<Alumno> findAlumnosByCurso(int idCurso);
	void saveAlumno(Alumno alumno);	
	void removeAlumno(int dni);
}
