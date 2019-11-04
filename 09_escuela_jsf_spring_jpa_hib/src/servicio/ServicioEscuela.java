package servicio;

import java.util.Date;
import java.util.List;

import model.Alumno;
import model.Curso;

public interface ServicioEscuela {
	public void matricular(Alumno alumno);
	public void eliminarCurso(int idCurso);
	public List<Curso> findAllCursos();
	public List<Curso> filtrarCursosPorFecha(Date fecha);
	List<Object[]> obtenerInfoTablaCursosPorFecha(Date fecha);
}
