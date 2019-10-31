package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Contacto;

@Repository
public class DaoContactosImpl implements DaoContactos {
	
	// Inyección de dependencia. Estamos inyectando el objeto EntityManager. Esta interface nos ofrece
	// las operaciones basicas que podemos realizar, de forma indirecta, contra la BD (a través de la capa de persistencia)
	@PersistenceContext(unitName = "UPagenda")
	EntityManager em;

	// EntityManager no nos permite recuperar de forma directa todos los contactos. 
	// Tenemos que crear un objeto de la interface Query o TypedQuery
	@Override
	public List<Contacto> dameContactos() {
		String jpql = "select c from Contacto c";
		Query q = em.createQuery(jpql);
		return (List<Contacto>)q.getResultList();
	}

	@Transactional
	@Override
	public void altaContactoParametrizado(Contacto contacto) {
		em.persist(contacto);		
	}
	
	@Transactional
	@Override
	public void eliminarContacto(int idContacto) {	
		em.remove(em.find(Contacto.class,idContacto));
	}

	@Override
	public List<Contacto> dameContactosPorNombre(String nombre) {
		String jpql = "select c from Contacto c where c.nombre like '%" + nombre + "%'";
		Query q = em.createQuery(jpql);
		
		// Consulta parametrizada
		// String jpql = "select c from Contacto c where c.nombre like ?1";
		// q.setParameter(1,"%"+n+"%");
		return (List<Contacto>)q.getResultList();
	}

	@Override
	public Contacto dameContacto(String email) {
		String jpql = "select c from Contacto c where c.email = '" + email + "'";
		Query q = em.createQuery(jpql);
		
		// Consulta parametrizada
		//String jpql = "select c from Contacto c where c.email = ?1";
		//q.setParameter(1,email);
		
		return (Contacto)q.getSingleResult();	
	}	
}
