package init.service;

import java.util.List;

import init.dao.DaoReserva;
import init.entities.Reserva;
import init.model.ReservaDto;
import init.utilidades.Mapeador;

public class ServiceReservaImpl implements ServiceReserva {

	
	Mapeador mapeador;
	DaoReserva daoReserva;
	
	@Override
	public void save(ReservaDto reservaDto) {
		// TODO Auto-generated method stub
		daoReserva.save(mapeador.reservaDtoToEntity(reservaDto));
	}

	@Override
	public List<ReservaDto> finByCliente(String usuario) {
		// TODO Auto-generated method stub
		return daoReserva.finByCliente(usuario)
					.stream()
					.map(r->mapeador.reservaEntityToDto(r))
					.toList();
	}

}
