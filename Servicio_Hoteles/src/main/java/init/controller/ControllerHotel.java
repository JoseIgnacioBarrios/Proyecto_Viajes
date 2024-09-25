package init.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import init.model.HotelDto;
import init.service.ServiceHotel;

@CrossOrigin("*")
@RestController
public class ControllerHotel {

	ServiceHotel serviceHotel;
	
	public ControllerHotel(ServiceHotel serviceHotel) {
		super();
		this.serviceHotel = serviceHotel;
	}
	@GetMapping(value = "buscarPorId/{idHotel}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HotelDto> buscarPorIdhotel(@PathVariable("idHotel") int idHotel) {
		try{
			HotelDto hoteldto= serviceHotel.findById(idHotel);
			return new ResponseEntity<HotelDto>(hoteldto,HttpStatus.OK);
		}catch (RuntimeException e) {
			return new ResponseEntity<>(null,HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	@GetMapping(value = "buscarPorLocalizacion/{localizacion}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<HotelDto>> buscaPorLocalizacion(@PathVariable("localizacion")String localizacion){
		try{
			List<HotelDto>hoteldto= serviceHotel.findByLocalizacion(localizacion);
			return new ResponseEntity<>(hoteldto,HttpStatus.OK);
		}catch (RuntimeException e) {
			return new ResponseEntity<>(null,HttpStatus.SERVICE_UNAVAILABLE);
		}
		
	}
	
	@GetMapping(value="destinos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> destinos(){
		//return serviceHotel.destinos();
		try {
			List<String> destinos= serviceHotel.destinos();
			return new ResponseEntity<>(destinos,HttpStatus.OK);
		}catch (RuntimeException ex) {
			return new ResponseEntity<>(null,HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	
}
