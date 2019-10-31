package managed;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import daos.DaoClientes;
import model.Cliente;

@ManagedBean (name = "registroBean")
@RequestScoped
public class RegistroBean {		
	Cliente cliente;
	private String repContra;
	
	@ManagedProperty("#{daoCli}")
	DaoClientes daoCli;	
	
	public RegistroBean() {
		cliente = new Cliente();
	}
	
	public String confirmar() {
		//Cliente cli = new Cliente(0,cliente.getEmail(),cliente.getPassword(),cliente.getTelefono(),cliente.getUsuario());				
		daoCli.registrar(cliente);
		return "login";
	}	
	
	public String registrar() {		
		return "registro";
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getRepContra() {
		return repContra;
	}

	public void setRepContra(String repContra) {
		this.repContra = repContra;
	}

	public DaoClientes getDaoCli() {
		return daoCli;
	}

	public void setDaoCli(DaoClientes daoCli) {
		this.daoCli = daoCli;
	}
}
