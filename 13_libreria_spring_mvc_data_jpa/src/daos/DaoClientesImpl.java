package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Cliente;

@Repository (value = "daoCli")
public class DaoClientesImpl implements DaoClientes {
	@PersistenceContext(unitName = "librosUP")
	EntityManager em;

	@Override
	public Cliente obtenerCliente(String user, String pass) {
		String jpql = "select c from Cliente c where c.usuario = ?1 and c.password = ?2";
		Query q = em.createQuery(jpql);
		q.setParameter(1,user);
		q.setParameter(2,pass);
		List<Cliente> clientes = (List<Cliente>)q.getResultList();
		return clientes.size()>0?(Cliente)clientes.get(0):null;
	}

	@Override
	public Cliente obtenerClientePorId(int idCliente) {
		return em.find(Cliente.class,idCliente);
	}

	@Transactional
	@Override
	public void registrar(Cliente c) {
		em.persist(c);		
	}
	
	@Override
	public boolean existe(String user, String pass) {
		String jpql = "select c from Cliente c where c.usuario = ?1 and c.password = ?2";
		Query q = em.createQuery(jpql);
		q.setParameter(1,user);
		q.setParameter(2,pass);
		return q.getResultList().size() > 0;
	}

	@Transactional
	@Override
	public void actualizar(Cliente c) {
		em.merge(c);		
	}

	@Transactional
	@Override
	public void eliminar(int idCliente) {
		em.remove(this.obtenerClientePorId(idCliente));		
	}

	@Override
	public List<Cliente> obtenerClientes() {
		TypedQuery<Cliente> q = em.createNamedQuery("Cliente.findAll",Cliente.class);
		return q.getResultList();		
	}
}
