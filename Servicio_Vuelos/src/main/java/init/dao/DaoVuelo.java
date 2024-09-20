package init.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import init.entities.Vuelo;

public interface DaoVuelo extends JpaRepository<Vuelo, Integer> {

	@Query("SELECT v FROM Vuelo v WHERE v.destino = ?1 AND v.plazas >= ?2")
	List<Vuelo> findByVueloDisponible(String destino, int nPersona);
	
	@Transactional
	@Modifying
	@Query("UPDATE Vuelo v SET v.plazas = v.plazas - ?1 WHERE v.idvuelo = ?2")
	void updateVuelo(int nReservas, int idVuelo);

}
