package init.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import init.dao.DaoHotel;
import init.entities.Hotel;
import init.model.HotelDto;
import init.utilidades.Mapeador;
@Service
public class ServiceHotelImpl implements ServiceHotel {

	DaoHotel daoHotel;
	Mapeador mapeador;
	
	public ServiceHotelImpl(DaoHotel daoHotel,Mapeador mapeador) {
		super();
		this.daoHotel = daoHotel;
		this.mapeador= mapeador;
		
	}

	@Override
	public List<HotelDto> findByLocalizacion(String localizacion) {
		try {
			return daoHotel.finByLocalizacion(localizacion)
					.stream()
					.map(h->mapeador.hotelEntityToDto(h))
					.toList();
		}catch (HttpClientErrorException e) {
			throw new RuntimeException();
		}
		
	}

	@Override
	public HotelDto findById(int idHotel) {
		try {
		Optional<Hotel>opHotel= daoHotel.findById(idHotel);
		return mapeador.hotelEntityToDto(opHotel.isPresent()?opHotel.get():new Hotel());
		}catch (HttpClientErrorException e) {
			throw new RuntimeException();
		}
		
	}

	@Override
	public List<String> destinos() {
		try {
			return daoHotel.destinos();
		}catch (HttpClientErrorException e) {
			throw new RuntimeException();
		}
		
	}

	

}
