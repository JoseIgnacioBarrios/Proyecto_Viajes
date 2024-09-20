package init.entities;



import org.springframework.data.annotation.Id;

import init.model.HotelDto;
import init.model.VueloDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idreserva;
	//private int hotel;
	//private int vuelo;
	private double precio;
	private String usuario;
	
	
	@OneToMany()
	@JoinColumn(name="hotel",
		referencedColumnName="idHotel")
	private HotelDto hotel;
	
	@OneToMany()
	@JoinColumn(name="vuelo",
		referencedColumnName="idvuelo")
	private VueloDto vuelo;
	
	//	@OneToMany()
	//	@JoinColumn(name="usuario",
	//		referencedColumnName="usuario")
	//	private List<ClienteDto> usuarios;

	public Reserva(int idreserva, double precio, String usuario, HotelDto hoteles, VueloDto vuelos) {
		super();
		this.idreserva = idreserva;
		this.precio = precio;
		this.usuario = usuario;
		this.hotel = hoteles;
		this.vuelo = vuelos;
	}

	public Reserva() {
		super();
	}

	public int getIdreserva() {
		return idreserva;
	}

	public void setIdreserva(int idreserva) {
		this.idreserva = idreserva;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public HotelDto getHotel() {
		return hotel;
	}

	public void setHotel(HotelDto hoteles) {
		this.hotel = hoteles;
	}

	public VueloDto getVuelo() {
		return vuelo;
	}

	public void setVuelo(VueloDto vuelos) {
		this.vuelo = vuelos;
	}

	

	
	


}
