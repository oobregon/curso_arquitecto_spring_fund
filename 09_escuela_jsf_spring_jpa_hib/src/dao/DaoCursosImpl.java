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
		return (List<Curso>)q.getResultList();
	}	
}