package init.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import init.model.ReservaDto;
import init.service.ServiceReserva;


@CrossOrigin
@RestController
public class ControllerReserva {
	
	ServiceReserva serviceReserva;

	public ControllerReserva(ServiceReserva serviceReserva) {
		super();
		this.serviceReserva = serviceReserva;
	}


	@PostMapping(value="altaReseva", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_HTML_VALUE)
	public @ResponseBody String altaReseva(@RequestBody ReservaDto reservaDto) {
		
		return String.valueOf(serviceReserva.save(reservaDto));
	}
	
	@GetMapping(value="buscarPorCliente/{cliente}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ReservaDto> buscarPorCliente(@PathVariable("cliente") String cliente) {
		return serviceReserva.finByCliente(cliente);
	}
	
	
	
	

}
