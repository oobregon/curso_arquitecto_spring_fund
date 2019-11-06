package spdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Cliente;

public interface DaoClientes extends JpaRepository<Cliente,Integer> {	
	
	// Si existen m�s de una combinaci�n usuario,contra, entonces
	// este metodo lanza una excepcion, que tendremos que capturar en la capa de servicio.
	public Cliente findByUsuarioAndPassword(String usuario,String contra);
}
