package controlador;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.Movimiento;
import service.ServicioCajero;

@ManagedBean
public class MovimientosBean {
	private double saldo;
	private List<Movimiento> movimientos;
	
	@ManagedProperty("#{capaservcajero}")
	ServicioCajero cajero;
	
	@ManagedProperty("#{loginBean}")
	LoginBean login;

	public ServicioCajero getCajero() {
		return cajero;
	}

	public void setCajero(ServicioCajero cajero) {
		this.cajero = cajero;
	}


	public double getSaldo() {
		saldo=cajero.obtenerSaldo(login.getCuenta());
		return saldo;
	}	

	public List<Movimiento> getMovimientos() {		
		movimientos=cajero.obtenerMovimientos(login.getCuenta());
		return movimientos;
	}

	public LoginBean getLogin() {
		return login;
	}

	public void setLogin(LoginBean login) {
		this.login = login;
	}		
}
