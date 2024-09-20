package init.utilidades;

import org.springframework.stereotype.Component;

import init.entities.Reserva;
import init.model.ReservaDto;

@Component
public class Mapeador {
	
	public ReservaDto reservaEntityToDto(Reserva reserva) {
		return new ReservaDto(reserva.getPrecio(),
							  reserva.getUsuario(),
							  reserva.getHotel(),
							  reserva.getVuelo());
	}
	
	public Reserva reservaDtoToEntity(ReservaDto reservaDto) {
		return new Reserva(0,
						   reservaDto.getPrecio(),
						   reservaDto.getUsuario(),
						   reservaDto.getHotel(),
						   reservaDto.getVuelo());
	}

}
