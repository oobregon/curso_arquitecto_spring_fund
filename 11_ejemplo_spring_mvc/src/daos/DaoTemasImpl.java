package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import model.Tema;

@Repository (value = "daoTemas")
public class DaoTemasImpl implements DaoTemas {
	@PersistenceContext(unitName = "librosUP")
	EntityManager em;

	@Override
	public List<Tema> obtenerTemas() {
		TypedQuery<Tema> q = em.createNamedQuery("Tema.todos",Tema.class);
		return q.getResultList();
	}
}
