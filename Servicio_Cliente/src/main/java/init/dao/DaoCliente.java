package init.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import init.entities.Cliente;

public interface DaoCliente extends JpaRepository<Cliente, String> {
	
	@Query("SELECT c FROM Cliente c WHERE c.usuario = ?1 AND c.password = ?2")
	Cliente findByUserPass(String usuario,String password);
	
	@Query("select c from Cliente c where c.usuario=?1")
	Cliente finByCliente(String usuario);
}
