package servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Cliente;
import model.Libro;
import spdatajpa.DaoClientes;
import spdatajpa.DaoLibros;

@Service (value = "capaServ")
public class CapaServicioImpl implements CapaServicio {
	@Autowired
	DaoClientes daoCli;
	
	@Autowired
	DaoLibros daoLib;

	@Override
	public boolean estaRegistrado(String usuario, String contra) {
		return this.obtenerCliente(usuario,contra)!=null?true:false;		
	}

	@Override
	public Cliente obtenerCliente(String usuario, String contra) {
		return daoCli.obtenerCliente(usuario, contra);
	}

	@Override
	public List<Libro> obtenerLibrosPorTema(int idTema) {
		return idTema==0?daoLib.findAll():daoLib.findLibroByTema(idTema);
	}	
}
