package init.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	private String usuario;
	private String password;
	private String direccion;
	private String tarjeta;
	private String dni;
	public Cliente(String usuario, String password, String direccion, String tarjeta, String dni) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.direccion = direccion;
		this.tarjeta = tarjeta;
		this.dni = dni;
	}
	public Cliente() {
		super();
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}

}
