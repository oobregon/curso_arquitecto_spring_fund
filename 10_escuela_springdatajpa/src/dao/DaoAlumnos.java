package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Alumno;
import model.Curso;

public interface DaoAlumnos extends JpaRepository<Alumno,Integer> {
	List<Alumno> findAlumnosByCurso(int idCurso);
	Alumno findAlumnoByDni(int dni);
	void saveAlumno(Alumno alumno);	
	void removeAlumno(int dni);
	
	@Query("select count(*) from Alumno a where a.curso.idCurso = ?1")
	int alumnosCurso(int idCurso);
}
