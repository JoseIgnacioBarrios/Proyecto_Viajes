package init.controller;

import org.springframework.web.bind.annotation.RestController;

import init.model.ReservaDto;
import init.service.ServiceReserva;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ControllerReserva {
	
	ServiceReserva serviceReserva;

	public ControllerReserva(ServiceReserva serviceReserva) {
		super();
		this.serviceReserva = serviceReserva;
	}


	@PostMapping(value="altaReseva", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String altaReseva(@RequestBody ReservaDto reserva) {
		//TODO: process POST request
		
		serviceReserva.save(reserva);
		return "ok";
	}
	

}
