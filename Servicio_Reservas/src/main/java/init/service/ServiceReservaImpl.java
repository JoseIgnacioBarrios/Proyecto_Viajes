package init.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import init.dao.DaoReserva;
import init.entities.Hotel;
import init.entities.Reserva;
import init.entities.Vuelo;
import init.model.ReservaDto;
import init.utilidades.Mapeador;

@Service
public class ServiceReservaImpl implements ServiceReserva {

	
	Mapeador mapeador;
	DaoReserva daoReserva;
	RestClient restClient;
	
	@Value("${servicio.hotel}")
	String urlServicioHotel;
	
	@Value("${servicio.vuelo}")
	String urlServicioVuelo;
	
	public ServiceReservaImpl(Mapeador mapeador,DaoReserva daoReserva, RestClient restClient) {
		this.daoReserva=daoReserva;
		this.mapeador=mapeador;
		this.restClient=restClient;
	}
	
	
	@Override
	public void save(ReservaDto reservaDto) {
		// TODO Auto-generated method stub
		
		Reserva reserva=mapeador.reservaDtoToEntity(reservaDto);
		
//actualizo el numero de plazas de vuelo
		restClient
			.put()
			.uri(urlServicioVuelo+"actualizarVuelo/"+reservaDto.getVuelo().getPlazas()+"/"+reservaDto.getVuelo().getIdvuelo())
			.retrieve();
		
//calcula el precio de la resrva
		reserva.setPrecio(reservaDto.getVuelo().getPlazas()*reservaDto.getVuelo().getPrecio());
		
//usamos servicio Hotel
		Hotel hotel= restClient
						.get()
						.uri(urlServicioHotel+"buscarPorId/"+reservaDto.getHotel().getIdHotel())
						.retrieve()
						.body(Hotel.class);
		reserva.setHotel(hotel);
		Vuelo vuelo=restClient
						.get()
						.uri(urlServicioVuelo+"buscarVuelo/"+reservaDto.getVuelo().getIdvuelo())
						.retrieve()
						.body(Vuelo.class);
		
		reserva.setVuelo(vuelo);
		
//crea la reserva
		daoReserva.save(reserva);
	}

	@Override
	public List<ReservaDto> finByCliente(String usuario) {
		// TODO Auto-generated method stub
		return daoReserva.finByCliente(usuario)
					.stream()
					.map(r->mapeador.reservaEntityToDto(r))
					.toList();
	}
	
	

}
