package init.service;

import org.springframework.stereotype.Service;

import init.model.ClienteDto;

@Service
public interface ServiceCliente {
	
//	DaoCliente daoCliente;
//	Mapeador mapeador;
	
	ClienteDto findByUsuario(String usuario);
	
	boolean findByUserPass(String usuario, String password);
	
	boolean save(ClienteDto cliente);

}
