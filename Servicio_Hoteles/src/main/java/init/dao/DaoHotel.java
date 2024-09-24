package init.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import init.entities.Hotel;

public interface DaoHotel extends JpaRepository<Hotel, Integer> {

	@Query("select h from Hotel h where h.localizacion=?1")
	List<Hotel> finByLocalizacion(String localizacion);
	
	@Query("SELECT DISTINCT h.localizacion FROM Hotel h")
	List<String> destinos();
}
