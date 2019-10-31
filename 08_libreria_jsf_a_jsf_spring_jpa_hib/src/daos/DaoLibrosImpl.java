package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import model.Libro;
import model.Tema;

@Repository (value = "daoLib")
public class DaoLibrosImpl implements DaoLibros {
	@PersistenceContext(unitName = "librosUP")
	EntityManager em;

	@Override
	public List<Libro> obtenerLibros() {
		TypedQuery<Libro> q = em.createNamedQuery("todos",Libro.class);
		return q.getResultList();
	}

	@Override
	public List<Libro> obtenerLibrosPorTema(int idTema) {
		Tema tema = em.find(Tema.class,idTema);
		return tema.getLibros();
	}
}
