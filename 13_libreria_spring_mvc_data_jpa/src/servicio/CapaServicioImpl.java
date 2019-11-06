package servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Cliente;
import model.Libro;
import model.Tema;
import model.Venta;
import spdatajpa.DaoClientes;
import spdatajpa.DaoLibros;
import spdatajpa.DaoTemas;
import spdatajpa.DaoVentas;

@Service (value = "capaServ")
public class CapaServicioImpl implements CapaServicio {
	@Autowired
	DaoClientes daoCli;
	
	@Autowired
	DaoLibros daoLib;
	
	@Autowired
	DaoTemas daoTem;
	
	@Autowired
	DaoVentas daoVen;

	@Override
	public boolean estaRegistrado(String usuario, String contra) {
		return this.obtenerCliente(usuario,contra)!=null?true:false;		
	}

	@Override
	public Cliente obtenerCliente(String usuario, String contra) {
		return daoCli.findByUsuarioAndPassword(usuario, contra);
	}

	@Override
	public List<Libro> obtenerLibrosPorTema(int idTema) {
		if(idTema == 0) {
			return daoLib.findAll();
		} else {
			Tema tema = daoTem.getOne(idTema);
			return daoLib.findAllByTema(tema);
		}		
	}

	@Override
	public void registrar(Cliente cliente) {
		daoCli.save(cliente);		
	}

	@Override
	public List<Tema> obtenerTemas() {
		return daoTem.findAll();
	}

	@Override
	public List<Venta> obtenerVentasCliente(int idCliente) {		
		Cliente cliente = daoCli.getOne(idCliente);
		return daoVen.findAllByCliente(cliente);
	}
}
