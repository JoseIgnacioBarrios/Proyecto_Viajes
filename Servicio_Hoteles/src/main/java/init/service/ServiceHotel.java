package init.service;

import java.util.List;
import init.model.HotelDto;

public interface ServiceHotel {
	
	List<HotelDto> findByLocalizacion(String localizacion);
	
	HotelDto findById(int idHotel);
}
