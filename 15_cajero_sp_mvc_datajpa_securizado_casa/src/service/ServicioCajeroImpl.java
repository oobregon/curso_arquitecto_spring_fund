package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DaoClientes;
import dao.DaoCuentas;
import dao.DaoMovimientos;
import model.Cliente;
import model.Cuenta;
import model.Movimiento;

@Service (value = "capaservcajero")
public class ServicioCajeroImpl implements ServicioCajero {
	// La capa de servicio no debe contener ninguna sentencia de acceso a datos, ninguna sentencia
	// de persistencia (no jdbc, no jpa, no ds). La capa que conoce el acceso a datos es la capa Dao.
	// Inyectar interfaces de negocio (EJB o spring), no son sentencias de acceso a datos. 
	//
	// Viendo esta capa de servicio no debemos ver ning�n v�nculo a tecnolog�as de acceso a 
	// datos. La inyecci�n de EJB,s es independiente de la tecnolog�a de acceso a datos (jpa,
	// jdbc,etc); si se cambia la tecnolog�a de acceso a datos, esta capa de servicio no se ve
	// alterada de forma alguna, la inyecci�n de dependencias seguir�a siendo tal y como es ahora.
	
	@Autowired
	DaoClientes daoCli;
	
	@Autowired
	DaoCuentas daoCuentas;
	
	@Autowired
	DaoMovimientos daoMov;

	@Override
	public Cuenta obtenerCuenta(int numCuenta) {
		Optional<Cuenta> optCuenta = daoCuentas.findById(numCuenta);
		return optCuenta.isPresent()?optCuenta.get():null;
		
	}

	@Transactional
	@Override
	public void extraer(int numCuenta, double cantidad) {
		Cuenta cuenta = daoCuentas.getOne(numCuenta);
		if(cuenta.getSaldo() >= cantidad) {
			cuenta.setSaldo(cuenta.getSaldo()-cantidad);
			daoCuentas.save(cuenta);			
			Movimiento mov = new Movimiento(0,cantidad,new Date(),"Extracci�n",cuenta);
			daoMov.save(mov);
		} else {
			throw new RuntimeException();
		}
	}

	@Transactional
	@Override
	public void ingresar(int numCuenta, double cantidad) {
		Cuenta cuenta = daoCuentas.getOne(numCuenta);
		cuenta.setSaldo(cuenta.getSaldo()+cantidad);
		daoCuentas.save(cuenta);
		Movimiento movimiento = new Movimiento(0,cantidad,new Date(),"Ingreso",cuenta);		
		daoMov.save(movimiento);
	}

	@Transactional
	@Override	
	public void transferir(int numCuentaOrigen, int numCuentaDestino, double cantidad) {
		this.extraer(numCuentaOrigen,cantidad);
		this.ingresar(numCuentaDestino,cantidad);
	}

	@Override
	public List<Cliente> obtenerTitulares(int idCuenta) {
		return daoCli.findAllByCuentas(idCuenta);
	}

	@Override
	public List<Movimiento> obtenerMovimientos(int numCuenta) {
		Cuenta cuenta = daoCuentas.getOne(numCuenta);
		return daoMov.findAllByCuenta(cuenta);
	}

	@Override
	public double obtenerSaldo(int numCuenta) {
		return daoCuentas.getOne(numCuenta).getSaldo();
	}
}
