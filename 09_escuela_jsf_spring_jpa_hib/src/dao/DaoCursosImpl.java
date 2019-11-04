package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Curso;

@Repository (value = "daoCursos")
public class DaoCursosImpl implements DaoCursos {
	@PersistenceContext(unitName = "UPescuela")
	EntityManager em;

	@Override
	public List<Curso> findAllCursos() {
		TypedQuery<Curso> q = em.createNamedQuery("Curso.findAll",Curso.class);
		return q.getResultList();	
	}

	@Transactional
	@Override
	public void removeCurso(int idCurso) {		
		Curso curso = em.find(Curso.class,idCurso);
		em.remove(curso);
	}

	@Override
	public List<Curso> findAllCursosByFecha(Date fecha) {
		String jpql = "select c from Curso c where c.fechaInicio >= ?1";		
		Query q = em.createQuery(jpql);
		q.setParameter(1,fecha);
		List<Curso> lista = (List<Curso>)q.getResultList();
		return lista;
	}

	@Override
	public List<Object[]> obtenerCursosConteoAlumnos(Date fecha) {
		List<Object[]> cursosConteoAlum;
		String jpql = "select c.idCurso,c.denominacion,c.duracion,c.fechaInicio,count(a.dni) as num_alumnos from Curso c "
				    + "left join Alumno a on c.idCurso =  a.curso.idCurso where c.fechaInicio >= ?1 "
				    + "group by c.idCurso,c.denominacion,c.duracion,c.fechaInicio";
		Query q = em.createQuery(jpql);
		q.setParameter(1,fecha);
		cursosConteoAlum = q .getResultList();
		return cursosConteoAlum;
	}
	

	@Override
	public Curso findCursoById(int idCurso) {
		return em.find(Curso.class,idCurso);
	}

	@Transactional
	@Override
	public void persistByEntity(Curso curso) {		
		em.persist(curso);		
	}

	@Override
	public int findNumAlumnosByCurso(int idCurso) {
		Curso curso = em.find(Curso.class,idCurso);
		return curso.getAlumnos().size();
	}	
}