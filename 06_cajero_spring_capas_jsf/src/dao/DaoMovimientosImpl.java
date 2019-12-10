package dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Movimiento;

@Repository
public class DaoMovimientosImpl implements DaoMovimientos {
	@Autowired
	JdbcTemplate accDatos;
	
	@Override
	public List<Movimiento> findMovimientoByCuenta(int numCuenta) {		
		String sql = "select * from movimientos where idCuenta = ?";		
		return accDatos.query(sql,(rs,filas) -> new Movimiento(rs.getInt("idMovimiento"),
															   rs.getDouble("cantidad"),
															   rs.getDate("fecha"),
															   rs.getString("operacion"),
															   numCuenta),numCuenta);
		}

	@Override
	public void saveMovimiento(Movimiento movimiento) {
		String sql = "insert into movimientos (idCuenta,fecha,cantidad,operacion) values (?,?,?,?)";
		accDatos.update(sql,movimiento.getIdCuenta(),
						    movimiento.getFecha(),
						    movimiento.getCantidad(),
						    movimiento.getOperacion());
	}
}
