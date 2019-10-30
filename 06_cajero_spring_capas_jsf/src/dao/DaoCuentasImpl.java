package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Cuenta;

@Repository
public class DaoCuentasImpl implements DaoCuentas {
	@Autowired
	JdbcTemplate accDatos;

	@Override
	public Cuenta findCuenta(int numCuenta) {
		String sql = "select * from cuentas where numeroCuenta = ?";
		return accDatos.query(sql,(rs,filas) -> new Cuenta(rs.getInt("numeroCuenta"),
				                                           rs.getDouble("saldo"),
				                                           rs.getString("tipocuenta")),numCuenta).get(0);
	}

	@Override
	public List<Cuenta> findAllCuenta() {
		String sql = "select * from cuentas";
		return accDatos.query(sql,(rs,filas) -> new Cuenta(rs.getInt("numeroCuenta"),
				                                           rs.getDouble("saldo"),
				                                           rs.getString("tipocuenta")));		
	}

	@Override
	public void updateCuenta(Cuenta cuenta) {
		String sql = "update cuentas set numeroCuenta = ?, saldo = ?, tipoCuenta = ? where numeroCuenta = ?";
		accDatos.update(sql,cuenta.getNumeroCuenta(),cuenta.getSaldo(),cuenta.getTipocuenta(),cuenta.getNumeroCuenta());
	}

}
