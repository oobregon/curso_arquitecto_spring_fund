package dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import model.Alumno;

public interface DaoAlumnos extends JpaRepository<Alumno,Integer> {			
	@Query("select count(*) from Alumno a where a.curso.idCurso = ?1")		
	public int findNumAlumnosByCurso(int idCurso);	
	
	@Query("select a from Alumno a where a.curso.idCurso = ?1")
	List<Alumno> findAlumnosByCurso(int idCurso);
}