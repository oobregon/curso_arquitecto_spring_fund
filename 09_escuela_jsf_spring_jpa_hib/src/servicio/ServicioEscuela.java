package servicio;

import java.util.Date;

public interface ServicioEscuela {
	public void matricular();
	public void borrarCurso(int idCurso);
	public void filtrarCursosPorFecha(Date fecha);
}
