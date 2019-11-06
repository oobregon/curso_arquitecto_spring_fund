package spdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Cliente;

public interface DaoClientes extends JpaRepository<Cliente,Integer> {	
	
	// Si existen más de una combinación usuario,contra, entonces
	// este metodo lanza una excepcion, que tendremos que capturar en la capa de servicio.
	public Cliente findByUsuarioAndPassword(String usuario,String contra);
}
