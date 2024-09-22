package init.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	
	@ManyToOne()
	@JoinColumn(name="hotel", referencedColumnName = "idHotel")
	private Hotel hotel;
	
	@ManyToOne()
	@JoinColumn(name="vuelo", referencedColumnName = "idvuelo")
	private Vuelo vuelo;
	
	//	@OneToMany()
	//	@JoinColumn(name="usuario",
	//		referencedColumnName="usuario")
	//	private List<ClienteDto> usuarios;

	public Reserva(int idreserva, double precio, String usuario, Hotel hotel, Vuelo vuelo) {
		super();
		this.idreserva = idreserva;
		this.precio = precio;
		this.usuario = usuario;
		this.hotel = hotel;
		this.vuelo = vuelo;
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

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hoteles) {
		this.hotel = hoteles;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelos) {
		this.vuelo = vuelos;
	}

	

	
	


}
