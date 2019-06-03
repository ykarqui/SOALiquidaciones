package ar.edu.iua.soa.banco.model.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.iua.soa.banco.model.Liquidacion;

public interface LiquidacionRepository extends JpaRepository<Liquidacion, Integer> {

	// getOneByLegajo
	@Query(value = "SELECT * FROM liquidacion WHERE fecha_pago=?", nativeQuery = true)
	public List<Liquidacion> findByLegajo(Integer legajo);

}
