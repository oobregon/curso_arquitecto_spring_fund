package controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import service.ServicioCajero;

// Nada nos hace sospechar cómo está implementado el modelo
// 
@ManagedBean
@SessionScoped
public class LoginBean {
	private int cuenta;
	
	@ManagedProperty("#{capaservcajero}")
	ServicioCajero cajero;
	

	public ServicioCajero getCajero() {
		return cajero;
	}

	public void setCajero(ServicioCajero cajero) {
		this.cajero = cajero;
	}

	public int getCuenta() {
		return cuenta;
	}

	public void setCuenta(int cuenta) {
		this.cuenta = cuenta;
	}
	
	public String entrar() {
		if(cajero.obtenerCuenta(cuenta) != null) {
			return "operaciones";
		} else {
			return null;
		}
	}
}
