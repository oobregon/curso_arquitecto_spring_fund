package dao;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import model.Curso;

public interface DaoCursos extends JpaRepository<Curso,Integer> {	
	// findByFechaInicio s� lo proporciona jpaRepository (porque sigue la convenci�n findByNombredePropiedadDelBean), 
	// pero la implementaci�n de Spring de �ste m�todo busca por igualdad, por lo tanto no nos vale porque
	// la l�gica de negocio de nuestra aplicaci�n requiere b�squeda por mayor o igual. En consecuencia, tenemos que 
	// decirle a spring que no use su implementaci�n, sino la nuestra; para ello, le indicamos la consulta asociada
	// a este m�todo:	
	@Query("select c from Curso c where c.fechaInicio >= ?1")
	List<Curso> findByFechaInicio(Date fecha);
}