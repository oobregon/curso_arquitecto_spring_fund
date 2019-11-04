package dao;

import java.util.Date;
import java.util.List;

import model.Curso;

public interface DaoCursos {
	List<Curso> findAllCursos();
	List<Curso> findAllCursosByFecha(Date fecha);
	Curso findCursoById(int idCurso);
	List<Object[]> obtenerCursosConteoAlumnos(Date fecha);
	void removeCurso(int idCurso);
	void persistByEntity(Curso curso);
}
