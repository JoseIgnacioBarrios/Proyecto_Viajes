package init.service;

import java.util.List;

import org.springframework.stereotype.Service;

import init.entities.Reserva;
import init.model.ReservaDto;

@Service
public interface ServiceReserva {

	public List<ReservaDto> finByCliente(String usuario);

	boolean save(ReservaDto reservaDto);
	
}
