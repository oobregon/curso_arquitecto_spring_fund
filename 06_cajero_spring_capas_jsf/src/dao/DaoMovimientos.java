package dao;

import java.util.List;

import model.Movimiento;

public interface DaoMovimientos {
	List<Movimiento> findMovimientoByCuenta(int numCuenta);
	void saveMovimiento(Movimiento movimiento);
}
