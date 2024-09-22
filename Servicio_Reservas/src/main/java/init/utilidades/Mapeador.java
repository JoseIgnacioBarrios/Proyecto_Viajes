package init.utilidades;

import org.springframework.stereotype.Component;

import init.entities.Hotel;
import init.entities.Reserva;
import init.entities.Vuelo;
import init.model.HotelDto;
import init.model.ReservaDto;
import init.model.VueloDto;

@Component
public class Mapeador {
	
	public ReservaDto reservaEntityToDto(Reserva reserva) {
		return new ReservaDto(reserva.getIdreserva(),
							  reserva.getPrecio(),
							  reserva.getUsuario(),
							  hotelEntityToDto(reserva.getHotel()),
							  vueloEntityToDto(reserva.getVuelo()));
	}
	
	public Reserva reservaDtoToEntity(ReservaDto reservaDto) {
		
		return new Reserva(reservaDto.getIdreserva(),
						   reservaDto.getPrecio(),
						   reservaDto.getUsuario(),
//						   hotelDtoToEntity(reservaDto.getHotel()),
//						   vueloDtoToEntity(reservaDto.getVuelo()));
						   new Hotel(),
						   new Vuelo());
	}
	
	public Hotel hotelDtoToEntity(HotelDto hotelDto) {
		return new Hotel(hotelDto.getIdHotel(),
						hotelDto.getNombre(),
						hotelDto.getCategoria(),
						hotelDto.getPrecio(),
						hotelDto.getDisponible(),
						hotelDto.getLocalizacion());
	}
	public Vuelo vueloDtoToEntity(VueloDto vueloDto) {
		return new Vuelo(vueloDto.getIdvuelo(),
						 vueloDto.getCompany(),
						 vueloDto.getFecha(),
						 vueloDto.getPrecio(),
						 vueloDto.getPlazas(),
						 vueloDto.getDestino());
	}
	public HotelDto hotelEntityToDto(Hotel hotel) {
		return new HotelDto(hotel.getIdHotel(),
						hotel.getNombre(),
						hotel.getCategoria(),
						hotel.getPrecio(),
						hotel.getDisponible(),
						hotel.getLocalizacion());
	}
	public VueloDto vueloEntityToDto(Vuelo vuelo) {
		return new VueloDto(vuelo.getIdvuelo(),
							vuelo.getCompany(),
							vuelo.getFecha(),
							vuelo.getPrecio(),
							vuelo.getPlazas(),
							vuelo.getDestino());
	}

}
