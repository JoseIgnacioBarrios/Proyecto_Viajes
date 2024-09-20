package init.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import init.dao.DaoVuelo;
import init.entities.Vuelo;
import init.model.VueloDto;
import init.utilidades.Mapeador;

@Service
public class ServiceVueloImpl implements ServiceVuelo {

	//dependencia DAO
	DaoVuelo daoVuelo;
	Mapeador mapeador;
	
	public ServiceVueloImpl(DaoVuelo daoVuelo, Mapeador mapeador) {
		super();
		this.daoVuelo = daoVuelo;
		this.mapeador=mapeador;
	}

	@Override
	public List<VueloDto> findByVueloDisponible(String destino, int nPersona) {
		return daoVuelo.findByVueloDisponible(destino, nPersona)
						.stream()
						.map(v->mapeador.vueloEntityToDto(v))
						.toList();
	}

	@Override
	public void updateVuelo(int nReservas, int idVuelo) {
		daoVuelo.updateVuelo(nReservas, idVuelo);
	}

	@Override
	public VueloDto findById(int idVuelo) {
		Optional<Vuelo> opVuelo=daoVuelo.findById(idVuelo);
		return opVuelo.isPresent()?mapeador.vueloEntityToDto(opVuelo.get()):new VueloDto();
	}

}
