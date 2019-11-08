package service;

import java.util.List;
import model.Cliente;
import model.Cuenta;
import model.Movimiento;

public interface ServicioCajero {
	Cuenta obtenerCuenta(int numCuenta);
	void extraer(int numCuenta,double cantidad);
	void ingresar(int numCuenta,double cantidad);
	void transferir(int numCuentaOrigen,int numCuentaDestino,double cantidad);
	List<Cliente> obtenerTitulares(int idCuenta);
	List<Movimiento> obtenerMovimientos(int numCuenta);
	double obtenerSaldo(int numCuenta);
}