package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Alumno;
import model.Curso;

public interface DaoCursos extends JpaRepository<Curso,Integer> {
	List<Curso> findAllCursos();
	
	// 
	// como buscamos no solo por igualdad sino por mayor o igual	
	@Query("select c from Curso c where c.fechaInicio >= ?1")
	List<Curso> findByFechaInicio(Date fecha);
	Curso findCursoById(int idCurso);
	List<Object[]> obtenerCursosConteoAlumnos(Date fecha);
		
	public int findNumAlumnosByCurso(int idCurso);
	
	void removeCurso(int idCurso);
	void persistByEntity(Curso curso);
}
