package init.controller;

import org.springframework.web.bind.annotation.RestController;


import init.model.ClienteDto;
import init.service.ServiceCliente;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin("*")
@RestController
public class ControllerCliente {
	

	ServiceCliente serviceCliente;

	public ControllerCliente(ServiceCliente serviceCliente) {
		super();
		this.serviceCliente = serviceCliente;
	}
	
	@GetMapping(value="buscarPorUsuario/{usuario}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ClienteDto buscarPorUsuario(@PathVariable("usuario") String usuario) {
		return serviceCliente.findByUsuario(usuario);
	}
	
	@GetMapping(value="ValidarUserPass/{usuario}/{contrasena}",produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String ValidarUserPass(@PathVariable("usuario") String usuario, @PathVariable("contrasena")String contrasena) {
		return String.valueOf( serviceCliente.findByUserPass(usuario, contrasena));
	}

	
	@PostMapping(value="save",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String save(@RequestBody ClienteDto cliente) {
			
		return String.valueOf(serviceCliente.save(cliente));	
	}
	
	
	
	
}
