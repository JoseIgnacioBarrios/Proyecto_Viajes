package init.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import init.entities.Reserva;

public interface DaoReserva extends JpaRepository<Reserva, Integer> {

	@Query("select r from Reserva r where r.usuario=?1")
	List<Reserva> finByCliente(String usuario);
}
