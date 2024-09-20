package init.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import init.model.HotelDto;
import init.service.ServiceHotel;

@RestController
public class ControllerHotel {

	ServiceHotel serviceHotel;
	
	public ControllerHotel(ServiceHotel serviceHotel) {
		super();
		this.serviceHotel = serviceHotel;
	}
	@GetMapping(value = "buscarPorId/{idHotel}",produces = MediaType.APPLICATION_JSON_VALUE)
	public HotelDto buscarPorIdhotel(@PathVariable("idHotel") int idHotel) {
		return serviceHotel.findById(idHotel);
	}
	@GetMapping(value = "buscarPorLocalizacion/{localizacion}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<HotelDto> buscaPorLocalizacion(@PathVariable("localizacion")String localizacion){
		return serviceHotel.findByLocalizacion(localizacion);
	}
}
