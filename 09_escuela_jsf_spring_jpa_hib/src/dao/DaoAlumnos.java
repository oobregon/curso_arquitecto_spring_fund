package dao;

import java.util.List;

import model.Alumno;

public interface DaoAlumnos {
	List<Alumno> findAlumnosByCurso(int idCurso);
	Alumno findAlumnoByDni(int dni);
	void saveAlumno(Alumno alumno);	
	void removeAlumno(int dni);
}
