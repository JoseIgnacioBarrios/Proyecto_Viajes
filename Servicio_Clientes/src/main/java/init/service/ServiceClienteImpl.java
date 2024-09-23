package init.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import init.dao.DaoCliente;
import init.entities.Cliente;
import init.model.ClienteDto;
import init.utilidades.Mapeador;

@Service
public class ServiceClienteImpl implements ServiceCliente {
	
	DaoCliente daoCliente;
	Mapeador mapeador;

	public ServiceClienteImpl(DaoCliente daoCliente,Mapeador mapeaddor) {
		super();
		this.daoCliente = daoCliente;
		this.mapeador=mapeaddor;
	}

	@Override
	public ClienteDto findByUsuario(String usuario) {
		return  mapeador.clienteEntityToDto(daoCliente.finByCliente(usuario));
	}

	@Override
	public boolean findByUserPass(String usuario, String password) {
		Optional<Cliente> opCliente=daoCliente.findByUserPass(usuario, password);
		
		return opCliente.isPresent()?true:false;
	}

	@Override
	public boolean save(ClienteDto cliente) {
		try{
			Cliente opcliente= daoCliente.save( mapeador.clienteDtoToEntity(cliente));
			return true;
		}catch (Exception e) {
			// mejorar la excepcion la que corresponda
			//throw new IllegalArgumentException();
			return false;
		}
		

	}

}
