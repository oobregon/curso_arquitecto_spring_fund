package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import daos.DaoClientes;
import model.Cliente;

@ManagedBean (name = "gestCliBean")
@RequestScoped
public class GestCliBean {
	List<Cliente> clientes;
	
	@ManagedProperty("#{daoCli}")
	DaoClientes daoCli;
	
	public DaoClientes getDaoCli() {
		return daoCli;
	}

	public void setDaoCli(DaoClientes daoCli) {
		this.daoCli = daoCli;
	}

	@PostConstruct
	private void inicio() {
		clientes = daoCli.obtenerClientes();
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}
