package spdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Cliente;
import model.Libro;
import model.Venta;

public interface DaoVentas extends JpaRepository<Venta,Integer> {	
	public List<Venta> findAllByCliente(Cliente cliente);
	public List<Venta> findAllByLibro(Libro libro);
}
