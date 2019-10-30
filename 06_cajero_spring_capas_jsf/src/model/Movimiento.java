package model;

import java.io.Serializable;
import java.util.Date;

public class Movimiento implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idMovimiento;

	private double cantidad;

	public Movimiento(int idMovimiento, double cantidad, Date fecha, String operacion,int idCuenta) {
		super();
		this.idMovimiento = idMovimiento;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.operacion = operacion;
		this.cuenta = idCuenta;
	}

	private Date fecha;

	private String operacion;

	private int cuenta;

	public Movimiento() {
	}

	public int getIdMovimiento() {
		return this.idMovimiento;
	}

	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public double getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getOperacion() {
		return this.operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public int getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(int cuenta) {
		this.cuenta = cuenta;
	}
}