package init.service;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import init.dao.DaoReserva;
import init.entities.Hotel;
import init.entities.Reserva;
import init.entities.Vuelo;
import init.model.ClienteDto;
import init.model.ReservaDto;
import init.utilidades.Mapeador;
import jakarta.annotation.PostConstruct;

@Service
public class ServiceReservaImpl implements ServiceReserva {

	
	Mapeador mapeador;
	DaoReserva daoReserva;
	RestClient restClient;
	
//	@Value("${servicio.hotel}")
//	String urlServicioHotel;
//	
//	@Value("${servicio.vuelo}")
//	String urlServicioVuelo;
//	
//	@Value("${servicio.cliente}")
//	String urlServicioCliente;
	
	String urlHotel;
	String urlVuelo;
	String urlCliente;
	
	public ServiceReservaImpl(Mapeador mapeador,DaoReserva daoReserva, RestClient restClient) {
		this.daoReserva=daoReserva;
		this.mapeador=mapeador;
		this.restClient=restClient;
	}
	
	@PostConstruct
	public void init() {
		//urlAll="http://"+url+":"+port+"/cursos/";
		//ahora con EUREKA
		
		urlHotel= "http://servicio-hotel/hotel/";
		
		
		urlVuelo="http://servicio-vuelo/vuelo/";
		
	
		urlCliente="http://servicio-cliente/cliente/";
	}
	
	@Override
	public boolean save(ReservaDto reservaDto) {
		// TODO Auto-generated method stub
		System.out.println("ENTRO EN SAVE DE RESERVA");
			Reserva reserva=mapeador.reservaDtoToEntity(reservaDto);
			
			String usuario=reservaDto.getUsuario();
			ClienteDto userAutentificado= restClient
											.get()
											.uri(urlCliente+"buscarPorUsuario/"+usuario)
											.retrieve()
											.body(ClienteDto.class);
											
			
			
	//actualizo el numero de plazas de vuelo
			System.out.println("userAutentificado : "+userAutentificado.getUsuario() + userAutentificado.getPassword());
			try {	
				restClient
					.put()
					.uri(urlVuelo+"actualizarVuelo/"+reservaDto.getVuelo().getPlazas()+"/"+reservaDto.getVuelo().getIdvuelo())
					.header("Authorization", "Basic "+getBase64(userAutentificado.getUsuario(),userAutentificado.getPassword()))
					.retrieve();
			}catch (HttpClientErrorException e) {
				System.out.println("cath de update Plazas");
				throw new RuntimeException();
			}
			
	
			
	//usamos servicio Hotel
			Hotel hotel= restClient
							.get()
							.uri(urlHotel+"buscarPorId/"+reservaDto.getHotel().getIdHotel())
							.retrieve()
							.body(Hotel.class);
			reserva.setHotel(hotel);
			
			Vuelo vuelo=restClient
							.get()
							.uri(urlVuelo+"buscarVuelo/"+reservaDto.getVuelo().getIdvuelo())
							.retrieve()
							.body(Vuelo.class);
			
			//calcula el precio de la resrva
			reserva.setPrecio(reservaDto.getVuelo().getPlazas()*vuelo.getPrecio());
			
			reserva.setVuelo(vuelo);
			
	//crea la reserva
			try {
				daoReserva.save(reserva);
				return true;
			}catch (HttpClientErrorException e) {
				System.out.println("cath save reserva");
				throw new RuntimeException();
			}
		
	}

	@Override
	public List<ReservaDto> finByCliente(String usuario) {
		// TODO Auto-generated method stub
		return daoReserva.finByCliente(usuario)
					.stream()
					.map(r->mapeador.reservaEntityToDto(r))
					.toList();
	}
	
	private String getBase64(String us ,String pwd) {
		String cad=us+":"+pwd;
		return Base64.getEncoder().encodeToString(cad.getBytes());
		
	}

	
	

}
