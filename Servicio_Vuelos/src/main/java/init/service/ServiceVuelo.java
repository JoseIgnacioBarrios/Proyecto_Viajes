package init.service;

import java.util.List;

import init.model.VueloDto;

public interface ServiceVuelo {
	
	List<VueloDto> findByVueloDisponible(String destino, int nPersona);
	
	void updateVuelo(int nReservas, int idVuelo);
	
	VueloDto findById(int idVuelo);

}
