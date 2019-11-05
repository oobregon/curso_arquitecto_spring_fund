package servicio;

import java.util.Date;
import java.util.List;
import dto.CursoView;
import model.Alumno;
import model.Curso;

public interface ServicioEscuela {
	public void matricular(Alumno alumno,int idCurso);
	public void registrarCurso(Curso curso);
	public void eliminarCurso(int idCurso);
	public List<Curso> obtenerTodosCursos();
	public Curso obtenerCursoPorId(int idCurso);
	public List<CursoView> obtenerCursosPorFecha(Date fecha);
}
