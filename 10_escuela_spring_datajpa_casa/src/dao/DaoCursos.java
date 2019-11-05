package dao;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import model.Curso;

public interface DaoCursos extends JpaRepository<Curso,Integer> {	
	// findByFechaInicio sí lo proporciona jpaRepository (porque sigue la convención findByNombredePropiedadDelBean), 
	// pero la implementación de Spring de éste método busca por igualdad, por lo tanto no nos vale porque
	// la lógica de negocio de nuestra aplicación requiere búsqueda por mayor o igual. En consecuencia, tenemos que 
	// decirle a spring que no use su implementación, sino la nuestra; para ello, le indicamos la consulta asociada
	// a este método:	
	@Query("select c from Curso c where c.fechaInicio >= ?1")
	List<Curso> findByFechaInicio(Date fecha);
}