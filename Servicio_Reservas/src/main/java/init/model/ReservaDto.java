package init.model;

public class ReservaDto {
	private int idreserva;
	private double precio;
	private String usuario;
	private HotelDto hotel;
	private VueloDto vuelo;
	public ReservaDto(int idreserva, double precio, String usuario, HotelDto hotel, VueloDto vuelo) {
		super();
		this.idreserva=idreserva;
		this.precio = precio;
		this.usuario = usuario;
		this.hotel = hotel;
		this.vuelo = vuelo;
	}
	public ReservaDto() {
		super();
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
	public int getIdreserva() {
		return idreserva;
	}
	public void setIdreserva(int idreserva) {
		this.idreserva = idreserva;
	}

}
