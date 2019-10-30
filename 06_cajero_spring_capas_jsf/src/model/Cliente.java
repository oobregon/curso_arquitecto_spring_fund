package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the clientes database table.
 * 
 */
@Entity
@Table(name="clientes")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int dni;

	public Cliente(int dni, String direccion, String nombre, int telefono) {
		super();
		this.dni = dni;
		this.direccion = direccion;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	private String direccion;

	private String nombre;

	private int telefono;

	//bi-directional many-to-many association to Cuenta
	@ManyToMany
	@JoinTable(name = "Titulares",
	joinColumns = @JoinColumn(name = "idCliente",referencedColumnName = "dni"),
	inverseJoinColumns = @JoinColumn(name = "idCuenta",referencedColumnName = "numeroCuenta"))
	private List<Cuenta> cuentas;

	public Cliente() {
	}

	public int getDni() {
		return this.dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return this.telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public List<Cuenta> getCuentas() {
		return this.cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

}