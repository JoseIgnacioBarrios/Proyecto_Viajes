package init.utilidades;

import org.springframework.stereotype.Component;

import init.entities.Cliente;
import init.model.ClienteDto;

@Component
public class Mapeador {

	public ClienteDto clienteEntityToDto(Cliente cliente) {
		return new ClienteDto();
	}
}
