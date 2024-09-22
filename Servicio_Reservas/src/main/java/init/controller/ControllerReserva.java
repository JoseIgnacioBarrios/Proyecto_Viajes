package init.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import init.model.ReservaDto;
import init.service.ServiceReserva;



@RestController
public class ControllerReserva {
	
	ServiceReserva serviceReserva;

	public ControllerReserva(ServiceReserva serviceReserva) {
		super();
		this.serviceReserva = serviceReserva;
	}


	@PostMapping(value="altaReseva", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String altaReseva(@RequestBody ReservaDto reservaDto) {
		//TODO: process POST request
		
		serviceReserva.save(reservaDto);
		return "ok";
	}
	
	@GetMapping(value="buscarPorCliente/{cliente}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ReservaDto> buscarPorCliente(@PathVariable("cliente") String cliente) {
		return serviceReserva.finByCliente(cliente);
	}
	
	

}
