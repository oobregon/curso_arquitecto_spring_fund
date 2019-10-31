package managed;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import daos.DaoClientes;
import daos.DaoLibros;
import model.Cliente;

@ManagedBean (name = "loginBean")
@SessionScoped
public class LoginBean {
	private String usuario;
	private String contra;
	private Cliente cliLogado;
	
	@ManagedProperty("#{daoCli}")
	DaoClientes daoCli;
	
	@ManagedProperty("#{daoLib}")
	DaoLibros daoLib;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContra() {
		return contra;
	}
	public void setContra(String contra) {
		this.contra = contra;
	}
	
	public Cliente getCliLogado() {
		return cliLogado;
	}
	public void setCliLogado(Cliente cliLogado) {
		this.cliLogado = cliLogado;
	}
	// Aquí introducimos lo que haríamos en el service de nuestros antiguos servlets.
	// ¿qué es lo que devolvía nuestro frontcontroler? Un nombre de vista.
	// Pues bien, este método nuestro login, tiene que devolver un nombre de vista.
	public String login() {	
		Cliente cli = daoCli.obtenerCliente(getUsuario(),getContra());
		if (cli.getUsuario().equals(getUsuario()) && cli.getPassword().equals(getContra())) {
			this.setCliLogado(cli);
			return "menu";
		} else {
			return "nologin";
		}
	}
	public DaoClientes getDaoCli() {
		return daoCli;
	}
	public DaoLibros getDaoLib() {
		return daoLib;
	}
	public void setDaoCli(DaoClientes daoCli) {
		this.daoCli = daoCli;
	}
	public void setDaoLib(DaoLibros daoLib) {
		this.daoLib = daoLib;
	}
}
