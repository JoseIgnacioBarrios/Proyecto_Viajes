package init.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import init.model.VueloDto;
import init.service.ServiceVuelo;

@CrossOrigin("*")
@RestController
public class ControllerVuelo {

	ServiceVuelo serviceVuelo;

	public ControllerVuelo(ServiceVuelo serviceVuelo) {
		super();
		this.serviceVuelo = serviceVuelo;
	}
	
	@GetMapping(value="vuelosDisponible/{destino}/{nPersona}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<VueloDto> vuelosDisponible(@PathVariable("destino")String destino,@PathVariable("nPersona")int nPersona ) {
		return serviceVuelo.findByVueloDisponible(destino, nPersona);
	}
	
	@PutMapping(value="actualizarVuelo/{nReserva}/{idVuelo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void actualizarVuelo(@PathVariable("nReserva")int nReserva ,@PathVariable("idVuelo") int idVuelo) {
		serviceVuelo.updateVuelo(nReserva, idVuelo);
	}
	
	@GetMapping("buscarVuelo/{idVuelo}")
	public VueloDto buscarVuelo(@PathVariable("idVuelo")int idVuelo) {
		return serviceVuelo.findById(idVuelo);
	}
	
	
	
}
