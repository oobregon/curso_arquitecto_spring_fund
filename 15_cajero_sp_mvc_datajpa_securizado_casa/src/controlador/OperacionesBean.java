package controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import service.ServicioCajero;

@ManagedBean
public class OperacionesBean {
	private double cantidad;
	private int destino;
	private int cambioCuenta;
	
	@ManagedProperty("#{capaservcajero}")
	ServicioCajero cajero;
	
	@ManagedProperty("#{loginBean}")
	LoginBean login;
	
	public String cambiarCuenta() {
		login.setCuenta(getCambioCuenta());
		return "operaciones";
	}
		
	public String ingreso() {
		cajero.ingresar(login.getCuenta(), cantidad);
		return "operaciones";
	}
	public String extraccion() {
		cajero.extraer(login.getCuenta(), cantidad);
		return "operaciones";
	}
	public String transferencia() {
		cajero.transferir(login.getCuenta(), destino, cantidad);
		return "operaciones";
	}
	
	public ServicioCajero getCajero() {
		return cajero;
	}

	public void setCajero(ServicioCajero cajero) {
		this.cajero = cajero;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public int getDestino() {
		return destino;
	}

	public void setDestino(int destino) {
		this.destino = destino;
	}
	
	public LoginBean getLogin() {
		return login;
	}

	public void setLogin(LoginBean login) {
		this.login = login;
	}	

	public int getCambioCuenta() {
		return cambioCuenta;
	}

	public void setCambioCuenta(int cambioCuenta) {
		this.cambioCuenta = cambioCuenta;
	}
}