package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;
import model.Curso;

@Repository (value = "daoAlumnos")
public class DaoAlumnosImplOrg implements DaoAlumnos {
	@PersistenceContext(unitName = "UPescuela")
	EntityManager em;

	@Override
	public List<Alumno> findAlumnosByCurso(int idCurso) {
		Curso curso = em.find(Curso.class,idCurso);
		return curso.getAlumnos();
	}

	@Transactional
	@Override
	public void saveAlumno(Alumno alumno) {
		em.persist(alumno);
	}

	@Transactional
	@Override
	public void removeAlumno(int dni) {
		Alumno alumno = em.find(Alumno.class,dni);
		em.remove(alumno);
	}

	@Override
	public Alumno findAlumnoByDni(int dni) {
		return em.find(Alumno.class,dni);
	}
}