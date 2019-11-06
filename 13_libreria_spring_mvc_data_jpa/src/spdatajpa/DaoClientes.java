package spdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Cliente;

public interface DaoClientes extends JpaRepository<Cliente,Integer> {			
	@Query("select c from Cliente c where c.usuario = ?1 and c.password = ?2")
	Cliente obtenerCliente(String usuario,String contra);
}
