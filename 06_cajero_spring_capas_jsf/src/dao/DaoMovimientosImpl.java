package dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import model.Movimiento;

public class DaoMovimientosImpl implements DaoMovimientos {
	@Autowired
	JdbcTemplate accDatos;

	@Override
	public List<Movimiento> findMovimientoByCuenta(int numCuenta) {		
		String sql = "select * from movimientos where idCuenta = ?";		
		return accDatos.query(sql,(rs,filas) -> new Movimiento(rs.getInt("idMovimiento"),
															   rs.getDouble("cantidad"),
															   rs.getDate("fecha"),
															   rs.getString("operaciones"),
															   numCuenta),numCuenta);
		}

	@Override
	public void saveMovimiento(Movimiento movimiento) {
		String sql = "insert into movimiento (idCuenta,fecha,cantidad,operacion) values (?,?,?,?)";
		accDatos.update(sql,movimiento.getIdCuenta(),
						    movimiento.getFecha(),
						    movimiento.getCantidad(),
						    movimiento.getOperacion());
	}
}
